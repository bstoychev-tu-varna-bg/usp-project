package com.tuvarna.uspproject.validator;

import com.tuvarna.uspproject.annotation.ModelNameConstraint;
import com.tuvarna.uspproject.util.BrandsAndModelsMap;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.Map;

public final class ModelNameValidator implements ConstraintValidator<ModelNameConstraint, String> {

    @Autowired
    private BrandsAndModelsMap brandsAndModelsMap;

    private Map<String, List<String>> map;

    @Override
    public void initialize(ModelNameConstraint constraintAnnotation) {
        map = brandsAndModelsMap.getMap();
    }


    @Override
    public boolean isValid(String modelInput, ConstraintValidatorContext constraintValidatorContext) {
        String brand = getKeyByValue(modelInput);
        if(brand == null){
            return false;
        }
        return isValidModelForBrand(brand, modelInput);
    }

    private String getKeyByValue(String value) {
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getValue().contains(value)) {
                return entry.getKey();
            }
        }
        return null;
    }

    private boolean isValidModelForBrand(String brand, String model){
        return map.get(brand).contains(model);
    }
}
