package org.apache.maven.archetypes.maven_archetype_webapp.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = PercentageValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPercentage {
    String message() default "Percentage must be between 0 and 100";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
