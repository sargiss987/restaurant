package com.example.restaurant.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = AllowedTableSeatsValuesValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AllowedTableSeatsValues {

  String message() default "The number of seats could only be the specified values 2,4,6,8,10,12";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
