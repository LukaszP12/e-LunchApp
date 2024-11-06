package pl.strefakursow.eLunchApp.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import pl.strefakursow.eLunchApp.model.PeriodTime;

public class PeriodTimeConstraintValidator implements ConstraintValidator<PeriodTimeConstraint, PeriodTime> {

    @Override
    public void initialize(PeriodTimeConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(PeriodTime periodTime, ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }
}
