package com.neoflex.edu.CalculatorHolidayPay.Service;

import com.neoflex.edu.CalculatorHolidayPay.Model.HolidayPayResponse;

import java.math.BigDecimal;

public interface CalculatorService {
    HolidayPayResponse getHolidayPayment(BigDecimal avgSalary, int numberHolidayDays);
}
