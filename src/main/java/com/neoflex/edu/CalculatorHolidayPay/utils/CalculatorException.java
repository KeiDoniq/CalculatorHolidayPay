package com.neoflex.edu.CalculatorHolidayPay.utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class CalculatorException
        extends RuntimeException {
    public CalculatorException(String message) {
        super(message);
    }
}