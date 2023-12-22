package com.api.ecommerce.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;

@Configuration
@AllArgsConstructor
public class SecurityConfig {

    private PasswordEncoder passwordEncoder;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors(httpSecurityCorsConfigurer ->
                        httpSecurityCorsConfigurer.configurationSource(request ->
                                new CorsConfiguration().applyPermitDefaultValues()
                        ))
                .authorizeHttpRequests(
                        (request) ->
                                request
                                        .requestMatchers("/h2-console/*").permitAll()
                                        .requestMatchers("/user/register").permitAll()
                                        .requestMatchers(HttpMethod.DELETE).hasRole("ADMIN")
                                        .requestMatchers(HttpMethod.POST).hasAnyRole("ADMIN", "USER")
                                        .requestMatchers(HttpMethod.GET).hasAnyRole("ADMIN", "USER")
                                        .requestMatchers(HttpMethod.PUT).hasAnyRole("ADMIN", "USER")
                                        .requestMatchers(toH2Console()).permitAll()
                                        .anyRequest().authenticated()
                )
                .headers(
                        header ->
                                header.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable)
                )
                .csrf(AbstractHttpConfigurer::disable)
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }


}
