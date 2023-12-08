package com.flexhamp.testcontainers.config;

import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

@Configuration
public class TestTestcontainersConfiguration {
    @Bean
    @ServiceConnection
    PostgreSQLContainer<?> postgresContainer(DynamicPropertyRegistry registry) {
        var container = new PostgreSQLContainer<>(DockerImageName.parse("postgres:15"));
        registry.add("postgresql.driver", container::getDriverClassName);
        return container;
    }
}
