package com.darknbolt.tortoise.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(request -> request
                .requestMatchers( "/register", "/images/**", "/login", "/js/**").permitAll()
                .anyRequest().authenticated());

        http.formLogin(login -> login
                .loginPage("/index")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/", true)
                .permitAll());

        return http.build();
    }
}
