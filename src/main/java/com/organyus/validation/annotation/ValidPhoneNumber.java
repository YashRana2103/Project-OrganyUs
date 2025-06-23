package com.organyus.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {}) // no separate validator needed
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Pattern(regexp = "\\d{10}", message = "Must be a valid 10-digit number")
@NotBlank(message = "Phone number is required")
public @interface ValidPhoneNumber {
    String message() default "Invalid phone number";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
