package com.api.ecommerce.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Component;

@Component
public class InMemoryUserConfig {

    @Bean
    public InMemoryUserDetailsManager  inMemoryUserDetailsManager() {
        return new InMemoryUserDetailsManager();
    }
    
}
