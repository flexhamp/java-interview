package com.flexhamp.testcontainers.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@Testcontainers
@SpringBootTest
@AutoConfigureMockMvc
class UserRestControllerTest {
//    @Container
//    @ServiceConnection
//    static PostgreSQLContainer<?> postgresContainer = new PostgreSQLContainer<>(DockerImageName.parse("postgres:15"));

    @Autowired
    MockMvc mockMvc;

    @Test
    void findAllUsers_ReturnsUserList() throws Exception {
        this.mockMvc.perform(get("/api/user/list")).andExpectAll(
                status().isOk(),
                content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON),
                content().json("""
                        [
                            {
                                "id": 1,
                                "username": "j.jameson"
                            },
                            {
                                "id": 2,
                                "username": "j.walker"
                            },
                            {
                                "id": 3,
                                "username": "j.daniels"
                            },
                            {
                                "id": 4,
                                "username": "j.dewar"
                            }
                        ]
                        """)
        );
    }
}