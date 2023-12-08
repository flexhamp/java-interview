package com.flexhamp.testcontainers;

import com.flexhamp.testcontainers.controller.UserRestController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = TestTestcontainersApplication.class)
class TestcontainersApplicationTests {
    @Autowired
    UserRestController userRestController;
    @Test
    void contextLoads() {
        assertThat(userRestController).isNotNull();
    }
}
