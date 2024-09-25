package com.neoflex.edu.CalculatorHolidayPay;

import com.neoflex.edu.CalculatorHolidayPay.Service.Implmnt.CalculatorServiceImplement;
import com.neoflex.edu.CalculatorHolidayPay.utils.CalculatorException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorServiceTest {

    private CalculatorServiceImplement calculatorService;

    private final BigDecimal avgSalaryTest = BigDecimal.valueOf(30000);
    private final int numberHolidaysDaysTest = 14;

    @BeforeEach
    void beforeEach() {
        calculatorService = new CalculatorServiceImplement();
    }

    @AfterEach
    void afterEach() {
        calculatorService = null;
    }

    @Test
    void getVacationPayCalculationTest() {
        BigDecimal holidayPayment = calculatorService.getHolidayPayment(avgSalaryTest, numberHolidaysDaysTest).getAmountHolidayPay();
        assertEquals(BigDecimal.valueOf(12470.99), holidayPayment);
    }

    @Test
    void throwCalculatorExceptionWrongAvgSalaryTest() {
        assertThrows(CalculatorException.class, () -> {
            BigDecimal negativeAvgSalary = BigDecimal.valueOf(-10000);
            calculatorService.getHolidayPayment(negativeAvgSalary, numberHolidaysDaysTest);
        });
    }
    @Test
    void throwCalculatorExceptionWrongNumberHolidayDaysTest() {
        assertThrows(CalculatorException.class, () -> {
            int negativeNumberHolidayDays = -10000;
            calculatorService.getHolidayPayment(avgSalaryTest, negativeNumberHolidayDays);
        });
    }

}