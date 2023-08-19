package com.example.restaurant.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Set;

public class AllowedTableSeatsValuesValidator
    implements ConstraintValidator<AllowedTableSeatsValues, Integer> {

  private static final Set<Integer> ALLOWED_VALUES = Set.of(2, 4, 6, 8, 10, 12);

  @Override
  public boolean isValid(Integer value, ConstraintValidatorContext context) {
    if (value == null) {
      return true;
    }

    return ALLOWED_VALUES.contains(value);
  }
}
