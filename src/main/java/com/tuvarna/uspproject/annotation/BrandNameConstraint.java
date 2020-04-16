package com.tuvarna.uspproject.annotation;

import com.tuvarna.uspproject.validator.BrandNameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = BrandNameValidator.class)
@Target( { ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface BrandNameConstraint {
    String message() default "Invalid brand name!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
