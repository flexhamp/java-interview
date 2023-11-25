package com.flexhamp.springboot.kafka.producer.service;

import com.flexhamp.springboot.kafka.producer.model.StringValue;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.function.Consumer;

@Slf4j
public class DataSenderKafka implements DataSender {
    private final KafkaTemplate<String, StringValue> template;

    private final Consumer<StringValue> sendAsk;

    private final String topic;

    public DataSenderKafka(String topic, KafkaTemplate<String, StringValue> template, Consumer<StringValue> sendAsk) {
        this.topic = topic;
        this.template = template;
        this.sendAsk = sendAsk;
    }

    @Override
    public void send(StringValue value) {
        try {
            log.info("value: {}", value);
            template.send(topic, value)
                    .whenComplete(
                            (result, ex) -> {
                                if (ex == null) {
                                    log.info("message id: {} was sent, offset: {}",
                                            value.id(),
                                            result.getRecordMetadata().offset());
                                    sendAsk.accept(value);
                                } else {
                                    log.error("message id: {} was not sent", value.id(), ex);
                                }
                            }
                    );
        } catch (Exception e) {
            log.error("send error, value: {}", value, e);
        }
    }
}
