package com.flexhamp.springboot.kafka.consumer.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flexhamp.springboot.kafka.consumer.model.StringValue;
import com.flexhamp.springboot.kafka.consumer.service.StringValueConsumer;
import com.flexhamp.springboot.kafka.consumer.service.StringValueConsumerLogger;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.support.JacksonUtils;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.scheduling.concurrent.ConcurrentTaskExecutor;

import java.util.List;
import java.util.concurrent.Executors;

@Slf4j
@Configuration
public class AppConfig {
    public final String topicName;

    public AppConfig(@Value("${app.kafka.topic:kafka-topic}") String topicName) {
        this.topicName = topicName;
    }

    @Bean
    public ObjectMapper objectMapper() {
        return JacksonUtils.enhancedObjectMapper();
    }

    @Bean
    public ConsumerFactory<String, StringValue> producerFactory(KafkaProperties kafkaProperties, ObjectMapper mapper) {
        var props = kafkaProperties.buildConsumerProperties();
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        props.put(JsonSerializer.TYPE_MAPPINGS, "com.flexhamp.springboot.kafka.producer.model.StringValue:com.flexhamp.springboot.kafka.consumer.model.StringValue");
        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 3);
        props.put(ConsumerConfig.MAX_POLL_INTERVAL_MS_CONFIG, 3_000);

        var kafkaConsumerFactory = new DefaultKafkaConsumerFactory<String, StringValue>(props);
        kafkaConsumerFactory.setValueDeserializer(new JsonDeserializer<>(mapper));
        return kafkaConsumerFactory;
    }

    @Bean("listenerContainerFactory")
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, StringValue>> listenerContainerFactory(
            ConsumerFactory<String, StringValue> consumerFactory
    ) {
        int concurrency = 1;
        var factory = new ConcurrentKafkaListenerContainerFactory<String, StringValue>();
        factory.setConsumerFactory(consumerFactory);
        factory.setBatchListener(true);
        factory.setConcurrency(1);
        factory.getContainerProperties().setIdleBetweenPolls(1_000);
        factory.getContainerProperties().setPollTimeout(1_000);

        var executor = Executors.newFixedThreadPool(concurrency, task -> new Thread(task, "kafka-task"));
        var listenerTaskExecutor = new ConcurrentTaskExecutor(executor);
        factory.getContainerProperties().setListenerTaskExecutor(listenerTaskExecutor);
        return factory;
    }

    @Bean
    public NewTopic topic() {
        return TopicBuilder.name(topicName).partitions(1).replicas(1).build();
    }

    @Bean
    public StringValueConsumer stringValueConsumerLogger() {
        return new StringValueConsumerLogger();
    }

    @Bean
    public KafkaClient stringValueConsumer(StringValueConsumer stringValueConsumer) {
        return new KafkaClient(stringValueConsumer);
    }

    public static class KafkaClient {
        private final StringValueConsumer stringValueConsumer;

        public KafkaClient(StringValueConsumer stringValueConsumer) {
            this.stringValueConsumer = stringValueConsumer;
        }

        @KafkaListener(topics = "${app.kafka.topic}", containerFactory = "listenerContainerFactory")
        public void listen(@Payload List<StringValue> values) {
            log.info("values, values.size:{}", values.size());
            stringValueConsumer.accept(values);
        }
    }
}
