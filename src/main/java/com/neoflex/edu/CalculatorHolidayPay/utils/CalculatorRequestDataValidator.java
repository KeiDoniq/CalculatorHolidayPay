package com.neoflex.edu.CalculatorHolidayPay.utils;


import java.math.BigDecimal;

public final class CalculatorRequestDataValidator{
    public static boolean validateAvgSalary(BigDecimal avgSalary){
        return (avgSalary != null && avgSalary.compareTo(BigDecimal.ZERO) >= 0);
    }
    public static boolean validateHolidayDays(Integer holidayDays){
        return (holidayDays != null && holidayDays >= 0);
    }
}