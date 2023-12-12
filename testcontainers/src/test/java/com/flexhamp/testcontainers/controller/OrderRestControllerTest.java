package com.flexhamp.testcontainers.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.RememberMeAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.UUID;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.authentication;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class OrderRestControllerTest {
    MockMvc mockMvc;

    @BeforeEach
    void setUp(final ApplicationContext applicationContext) {
        this.mockMvc = applicationContext.getBean(MockMvc.class);
    }

    @Test
    void permitAll() throws Exception {
        this.mockMvc.perform(get("/permit-all"))
                .andExpect(status().isOk());


        this.mockMvc.perform(get("/permit-all")
                        .with(user("j.beam")))
                .andExpect(status().isOk());

        this.mockMvc.perform(get("/permit-all")
                        .with(
                                authentication(new RememberMeAuthenticationToken(UUID.randomUUID().toString(),
                                        User.builder().username("j.walker").password("{noop}nopassword").authorities("ROLE_USER").build(),
                                        List.of(new SimpleGrantedAuthority("ROLE_USER"))))
                        )
                )
                .andExpect(status().isOk());
    }

    @Test
    void denyAll() throws Exception {
        this.mockMvc.perform(get("/denny-all"))
                .andExpect(status().isForbidden());


        this.mockMvc.perform(get("/denny-all")
                        .with(user("j.beam")))
                .andExpect(status().isForbidden());

        this.mockMvc.perform(get("/denny-all")
                        .with(
                                authentication(new RememberMeAuthenticationToken(UUID.randomUUID().toString(),
                                        User.builder().username("j.walker").password("{noop}nopassword").authorities("ROLE_USER").build(),
                                        List.of(new SimpleGrantedAuthority("ROLE_USER"))))
                        )
                )
                .andExpect(status().isForbidden());
    }

    @Test
    void anonymous() {
    }

    @Test
    void authenticated() {
    }

    @Test
    void rememberMe() {
    }

    @Test
    void fullyAuthenticated() {
    }

    @Test
    void hasViewAuthority() throws Exception {
        this.mockMvc.perform(get("/has-view-authority"))
                .andExpect(status().isForbidden());


        this.mockMvc.perform(get("/has-view-authority")
                        .with(user("j.beam")))
                .andExpect(status().isForbidden());

        this.mockMvc.perform(get("/has-view-authority")
                        .with(user("j.beam").authorities(new SimpleGrantedAuthority("view")))
                )
                .andExpect(status().isOk());
    }

    @Test
    void hasUpdateOrDeleteAuthority() {
    }

    @Test
    void hasAdminRole() {
    }

    @Test
    void hasCustomerOrManagerRole() {
    }

    @Test
    void hasAccess() {
    }
}