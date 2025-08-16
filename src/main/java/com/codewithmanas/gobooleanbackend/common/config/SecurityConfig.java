package com.codewithmanas.gobooleanbackend.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final CorsConfigurationSource corsConfigurationSource;

    public SecurityConfig(CorsConfigurationSource corsConfigurationSource) {
        this.corsConfigurationSource = corsConfigurationSource;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            http.
                    cors(cors -> cors.configurationSource(corsConfigurationSource))
                    .csrf(csrf -> csrf.disable())
                    .authorizeHttpRequests(auth -> auth
//                            .requestMatchers("/api/v1/auth/**", "/api/v1/users/**", "/health", "/").permitAll()
                            .requestMatchers("/**").permitAll()
                            .anyRequest()
                            .authenticated()
                    )
                    // Allow frames from same origin so the console renders
                    .headers(headers -> headers.frameOptions(frame -> frame.sameOrigin()));

            return http.build();
        }
}
