package com.organyus.validation.validator;

import com.organyus.validation.annotation.SecurePassword;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

// This class implements the SecurePassword annotation to validate passwords
public class SecurePasswordValidator implements ConstraintValidator<SecurePassword, String> {

    // 6–64 chars, at least 1 letter, 1 digit, 1 special char
    private static final String PASSWORD_PATTERN =
            "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{6,64}$";

    // Compile the regex pattern for performance
    private final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);

    // Initialize the validator
    // This method is called by the validation framework before validation starts
    @Override // Override annotation to indicate this method overrides a method from the interface
    public boolean isValid(String password, ConstraintValidatorContext context) {
        if (password == null) return false;
        return pattern.matcher(password).matches(); // Check if the password matches the pattern
    }
}
