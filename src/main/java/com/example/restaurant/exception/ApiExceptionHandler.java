package com.example.restaurant.exception;

import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler implements ErrorController {

  public static final String NOT_ALLOWABLE_VALUE = "not allowable value";

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(
      MethodArgumentNotValidException ex) {
    return ResponseEntity.badRequest()
        .body(
            ex.getBindingResult().getFieldErrors().stream()
                .collect(
                    Collectors.toMap(
                        FieldError::getField,
                        fieldError ->
                            fieldError.getDefaultMessage() != null
                                ? fieldError.getDefaultMessage()
                                : NOT_ALLOWABLE_VALUE)));
  }
}
