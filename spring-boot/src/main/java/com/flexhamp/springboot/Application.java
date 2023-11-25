package com.flexhamp.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@PropertySource({"classpath:kafka/application.yml"})
public class Application {

	public static void main(String[] args) {
//		System.setProperty("spring.config.additional-location", "spring-boot/src/main/resources/kafka/");
		System.setProperty("spring.config.additional-location", "classpath:/kafka/");
		SpringApplication.run(Application.class, args);
	}

}
