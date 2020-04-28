package com.tuvarna.uspproject.annotation;

import com.tuvarna.uspproject.validator.ModelNameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ModelNameValidator.class)
public @interface ModelNameConstraint {
    String message() default "Invalid model name!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
