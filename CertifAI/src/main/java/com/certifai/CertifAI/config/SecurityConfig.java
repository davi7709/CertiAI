package com.certifai.CertifAI.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .securityMatcher("/**") // aplica a segurança para todas as rotas
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/user/register", "/user/listAll").permitAll()
                        .anyRequest().authenticated()
                )
                .csrf(csrf -> csrf.disable()) // desativa CSRF
                .httpBasic(Customizer.withDefaults()); // ativa autenticação básica

        return http.build();
    }
}

