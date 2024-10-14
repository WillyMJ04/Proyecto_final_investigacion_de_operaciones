package com.example.project.project_io.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .cors() // Habilita CORS en la configuración de seguridad
            .and()
            .csrf().disable() // Deshabilita CSRF si es necesario
            .authorizeRequests()
            .anyRequest().permitAll(); // Ajusta según tus necesidades de autenticación
        return http.build();
    }
}
