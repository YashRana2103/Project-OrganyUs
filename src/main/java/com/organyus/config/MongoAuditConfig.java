package com.organyus.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

@Configuration
public class MongoAuditConfig {

    @Bean
    public AuditorAware<String> auditorProvider() {
        // You can plug in logged-in user here if using Spring Security
        return () -> Optional.of("System"); // or return Optional.of(userId);
    }

    // TODO: see how to manage this userId
}
