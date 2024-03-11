package com.example.demo.misc;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PositiveIntArrayValidator implements ConstraintValidator<PositiveIntArray, int[]> {

    @Override
    public boolean isValid(int[] array, ConstraintValidatorContext context) {
        if (array == null) {
            return true; // Null arrays are considered valid
        }
        for (int num : array) {
            if (num <= 0) {
                return false; // Found a non-positive element
            }
        }
        return true; // All elements are positive
    }
}