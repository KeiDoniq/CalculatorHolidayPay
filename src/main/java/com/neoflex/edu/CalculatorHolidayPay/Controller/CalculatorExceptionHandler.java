package com.neoflex.edu.CalculatorHolidayPay.Controller;


import com.neoflex.edu.CalculatorHolidayPay.utils.CalculatorException;
import com.neoflex.edu.CalculatorHolidayPay.Model.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;


@RestControllerAdvice
public class CalculatorExceptionHandler {
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorResponse> handleException(MethodArgumentTypeMismatchException e) {
        return ResponseEntity.badRequest()
                .body(ErrorResponse.builder()
                        .responseMessage(e.getMessage())
                        .build());
    }
    @ExceptionHandler(CalculatorException.class)
    public ResponseEntity<ErrorResponse> handleException(CalculatorException e) {
        return ResponseEntity
                .badRequest()
                .body(ErrorResponse.builder()
                        .responseMessage(e.getMessage())
                        .build());
    }
}