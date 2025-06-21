package com.organyus.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

@Configuration
public class MongoAuditConfig {

    // Provides the current auditor (e.g. "system") for @CreatedBy/@LastModifiedBy

    @Bean
    public AuditorAware<String> auditorProvider() {
        // You can plug in logged-in user here if using Spring Security
        // TODO: replace with logged-in user after adding session/auth
        return () -> Optional.of("System"); // or return Optional.of(userId);
    }

}
