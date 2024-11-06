package pl.strefakursow.eLunchApp.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PeriodConstraintValidator.class)
@Documented
public @interface PeriodTimeConstraint {
    String message() default "{pl.strefakursow.eLunchApp.validator.PeriodTimeConstraint}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
