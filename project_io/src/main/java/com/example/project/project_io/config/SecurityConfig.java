package com.example.project.project_io.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(@org.jetbrains.annotations.NotNull HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((requests) -> requests
                .requestMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html").permitAll()
                .anyRequest().authenticated()
            )
            .csrf(csrf -> csrf.disable()) // Deshabilitar CSRF
            .formLogin(withDefaults()) // Usar la configuración por defecto para login
            .httpBasic(withDefaults()); // Usar la configuración por defecto para autenticación básica

        return http.build();
    }
}