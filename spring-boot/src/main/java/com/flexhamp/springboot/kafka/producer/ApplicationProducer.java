package com.flexhamp.springboot.kafka.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationProducer {
	public static void main(String[] args) {
		System.setProperty("spring.config.additional-location", "classpath:/kafka/producer/");
		SpringApplication.run(ApplicationProducer.class, args);
	}

}
