package com.organyus.validation.annotation;

import com.organyus.validation.validator.SecurePasswordValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME) // This annotation can be applied to fields and will be retained at runtime
@Constraint(validatedBy = SecurePasswordValidator.class) // This annotation is used to specify the validator class that will handle the validation logic
@Documented
public @interface SecurePassword {
    String message() default "Password must be 6–64 chars, include letters, digits & special characters";
    Class<?>[] groups() default {}; // This allows you to group constraints together
    Class<? extends Payload>[] payload() default {}; // This can carry additional information about the validation
}

