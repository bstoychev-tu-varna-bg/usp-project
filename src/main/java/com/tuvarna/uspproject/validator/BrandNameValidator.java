package com.tuvarna.uspproject.validator;

import com.tuvarna.uspproject.annotation.BrandNameConstraint;
import com.tuvarna.uspproject.util.BrandsAndModelsMap;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.Map;

public final class BrandNameValidator implements ConstraintValidator<BrandNameConstraint, String> {
    @Autowired
    private BrandsAndModelsMap brandsAndModelsMap;

    private Map<String, List<String>> map;

    @Override
    public void initialize(BrandNameConstraint constraintAnnotation) {
        map = brandsAndModelsMap.getMap();
    }


    @Override
    public boolean isValid(String brandInput, ConstraintValidatorContext constraintValidatorContext) {
        return isValidBrand(brandInput);
    }

    private boolean isValidBrand(String brand){
        return map.containsKey(brand);
    }
}
