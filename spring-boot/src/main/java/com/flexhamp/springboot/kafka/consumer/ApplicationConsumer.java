package com.flexhamp.springboot.kafka.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationConsumer {
    public static void main(String[] args) {
        System.setProperty("spring.config.additional-location", "classpath:/kafka/consumer/");
        SpringApplication.run(ApplicationConsumer.class, args);
    }

}
