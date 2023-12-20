package com.example.storeApi.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@AllArgsConstructor
public class SecurityConfig {

    private BCryptPasswordEncoder passwordEncoder;
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
                                        .requestMatchers(HttpMethod.DELETE).hasRole("ADMIN")
                                        .requestMatchers(HttpMethod.POST).hasAnyRole("ADMIN", "USER")
                                        .requestMatchers(HttpMethod.GET).permitAll()
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

    @Bean
    public UserDetailsService users() {
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("admin-pass"))
                .roles("ADMIN")
                .build();

        UserDetails user = User.builder()
                .username("user")
                .password(passwordEncoder.encode("user-pass"))
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(admin, user);
    }


}
