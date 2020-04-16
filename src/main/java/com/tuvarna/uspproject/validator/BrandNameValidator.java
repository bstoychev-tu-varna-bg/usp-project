package com.tuvarna.uspproject.validator;

import com.tuvarna.uspproject.annotation.BrandNameConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public final class BrandNameValidator implements ConstraintValidator<BrandNameConstraint, String> {

    private List<String> brandNames;

    @Override
    public void initialize(BrandNameConstraint constraintAnnotation) {
        brandNames = initializeList();
    }

    @Override
    public boolean isValid(String brandField, ConstraintValidatorContext constraintValidatorContext) {
        return brandNames.contains(brandField);
    }

    private List<String> initializeList() {
        return Arrays.asList("Mercedes-Benz", "Audi", "BMW", "Renault", "Peugeot", "Citroen");
    }
}
