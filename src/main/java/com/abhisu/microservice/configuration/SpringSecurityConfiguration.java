package com.abhisu.microservice.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

//        All request should be authenticated.
        http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
//        If a request is not authenticated a Log page is shown.
        http.httpBasic(Customizer.withDefaults());
//        CSRF -> PUT, POST
        http.csrf().disable();
        return http.build();
    }
}
