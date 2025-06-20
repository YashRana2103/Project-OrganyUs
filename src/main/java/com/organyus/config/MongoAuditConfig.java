package com.organyus.config;

import com.organyus.user.User;
import org.bson.types.ObjectId;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@Configuration
public class MongoAuditConfig {

//    @Bean
//    public AuditorAware<String> auditorProvider() {
//        // You can plug in logged-in user here if using Spring Security
//        return () -> Optional.of("System"); // or return Optional.of(userId);
//    }

    // TODO: see how to manage this userId
//    @Bean
//    public AuditorAware<String> auditorProvider(ObjectId userId) {
//        // You can plug in logged-in user here if using Spring Security
//        return () -> Optional.of(String.valueOf(userId));
//    }
    @Bean
    public AuditorAware<CustomAuditor> auditorProvider() {
        return () -> {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

            if (authentication == null || !authentication.isAuthenticated()) {
                return Optional.empty();
            }

            Object principal = authentication.getPrincipal();
            if (principal instanceof User user) {
                return Optional.of(new CustomAuditor(user.getId(), user.getFullName()));
            } else {
                return Optional.empty(); // or log a warning
            }
        };
    }
}
