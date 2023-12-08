package com.flexhamp.testcontainers;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

import javax.sql.DataSource;

//@Configuration()
////@TestConfiguration(proxyBeanMethods = false)
//public class TestTestcontainersApplication {
//
////    @Bean(initMethod = "start", destroyMethod = "stop")
////    @ServiceConnection
//    @Bean
//    PostgreSQLContainer<?> postgresContainer() {
//        return new PostgreSQLContainer<>(DockerImageName.parse("postgres:15"));
//    }
//
//    @Bean
//    public DataSource dataSource(PostgreSQLContainer<?> postgresContainer) {
//        var hikariDataSource = new HikariDataSource();
//        hikariDataSource.setJdbcUrl(postgresContainer.getJdbcUrl());
//        hikariDataSource.setUsername(postgresContainer.getUsername());
//        hikariDataSource.setPassword(postgresContainer.getPassword());
//
//        return hikariDataSource;
//    }
//
//    public static void main(String[] args) {
//        SpringApplication.from(TestcontainersApplication::main).with(TestTestcontainersApplication.class).run(args);
//    }
//
//}
