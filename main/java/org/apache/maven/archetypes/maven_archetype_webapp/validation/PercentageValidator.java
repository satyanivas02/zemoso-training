package org.apache.maven.archetypes.maven_archetype_webapp.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PercentageValidator implements ConstraintValidator<ValidPercentage, Integer> {
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (value == null) {
            return false; // Null value is not valid
        }
        return value >= 0 && value <= 100;
    }
}
