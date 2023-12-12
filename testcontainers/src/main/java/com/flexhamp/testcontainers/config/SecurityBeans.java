package com.flexhamp.testcontainers.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityBeans {

    @Bean
    SecurityFilterChain securityFilterChain(final HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests
                        // Тут порядок имеет значание
//                        .anyRequest().denyAll()
//                        .requestMatchers(AntPathRequestMatcher.antMatcher("")).denyAll()
//                        .requestMatchers(new IpAddressMatcher("127.0.0.1")).denyAll() // По Ip

//                        .requestMatchers(HttpMethod.GET, "/permit-all").permitAll() // разрешить всем, но только GET
                        .requestMatchers("/permit-all").permitAll() // разрешить всем
                        .requestMatchers("/denny-all").denyAll() // запретить всем
                        .requestMatchers("/anonymous").anonymous() // доступ только для неаутентифицированных пользователей
                        .requestMatchers("/authenticated").authenticated() // доступ только для аутентифицированных пользователей
                        .requestMatchers("/rememberMe").rememberMe() // доступ только для пользователей, которые поставили галочку remember me
                        .requestMatchers("/fullyAuthenticated").fullyAuthenticated() // доступ только для пользователей, которые прошли полную аутентифицированных, а не пользователей, которые были восстановлены по rememberMe
                        .requestMatchers("/has-view-authority").hasAuthority("view") // доступ только для пользователей, у которых есть право/полномочия view
                        .requestMatchers("/has-update-or-delete-authority").hasAnyAuthority("update", "delete") // доступ только для пользователей, у которых есть любое из указанных прав update/delete
                        .requestMatchers("/has-admin-role").hasRole("admin") // доступ только для пользователей, у которых есть роль admin
                        .requestMatchers("/has-customer-or-manager-role").hasAnyRole("customer", "manager") // доступ только для пользователей, у которых есть роль customer или manager
                        .requestMatchers("/has-access").access(((authentication, object) ->
                                new AuthorizationDecision("c.norris".equals(authentication.get().getName())))) // функциональный подход к определению правил доступа...
                )
                .build();
    }
}
