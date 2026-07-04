package com.app.hrms.config;

import com.app.hrms.security.CustomUserDetailsService;
import com.app.hrms.security.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final CustomUserDetailsService customUserDetailsService;
    private final JwtAuthenticationFilter  jwtAuthenticationFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

            http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth

                // Public APIs
                .requestMatchers(
                        "/swagger-ui/**",
                        "/v3/api-docs/**",
                        "/swagger-ui.html",
                        "/api-docs/**",
                        "/api/auth/**"
                ).permitAll()

                // User Management
                .requestMatchers("/api/users/**")
                .hasRole("ADMIN")

                // Master Data
                .requestMatchers("/api/roles/**")
                .hasRole("ADMIN")

                .requestMatchers("/api/departments/**")
                .hasAnyRole("ADMIN", "HR")

                .requestMatchers("/api/designations/**")
                .hasAnyRole("ADMIN", "HR")

                // Employee
                .requestMatchers("/api/employees/**")
                .hasAnyRole("ADMIN", "HR")

                // Leave
                .requestMatchers("/api/leaves/**")
                .hasAnyRole("ADMIN", "HR", "MANAGER", "EMPLOYEE")

                // Attendance
                .requestMatchers("/api/attendance/**")
                .hasAnyRole("ADMIN", "HR", "MANAGER", "EMPLOYEE")

                // Payroll
                .requestMatchers("/api/payroll/**")
                .hasAnyRole("ADMIN", "HR", "FINANCE")

                // Everything else
                .anyRequest().authenticated())
                .sessionManagement(session ->
                            session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    )
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(
                            jwtAuthenticationFilter,
                            UsernamePasswordAuthenticationFilter.class
                    );;

    // To Skip Spring Security Uncomment below and comment above section.
                    /* http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()
                );*/

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider =  new DaoAuthenticationProvider(customUserDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception{
        return authConfig.getAuthenticationManager();
    }
}