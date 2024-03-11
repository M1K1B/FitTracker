package com.example.demo.misc;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = PositiveIntArrayValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface PositiveIntArray {
    String message() default "Morate odabrati barem jednu vežbu.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}