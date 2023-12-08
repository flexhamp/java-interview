package com.flexhamp.testcontainers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

@TestConfiguration(proxyBeanMethods = false)
public class TestTestcontainersApplication {

    @Bean
    @ServiceConnection
    PostgreSQLContainer<?> postgresContainer(DynamicPropertyRegistry registry) {
        var container = new PostgreSQLContainer<>(DockerImageName.parse("postgres:15"));
        registry.add("postgresql.driver", container::getDriverClassName);
        return container;
    }

    public static void main(String[] args) {
        SpringApplication.from(TestcontainersApplication::main)
                .with(TestTestcontainersApplication.class).run(args);
    }
}
