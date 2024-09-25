package com.neoflex.edu.CalculatorHolidayPay.Service.Implmnt;

import com.neoflex.edu.CalculatorHolidayPay.Model.HolidayPayResponse;
import com.neoflex.edu.CalculatorHolidayPay.Service.CalculatorService;
import com.neoflex.edu.CalculatorHolidayPay.utils.CalculatorException;
import com.neoflex.edu.CalculatorHolidayPay.utils.CalculatorRequestDataValidator;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class CalculatorServiceImplement implements CalculatorService {
    public static final double TAX_PERCENT = 0.13;
    public static final double AVG_DAYS_PER_MONTH = 29.3;
    @Override
    public HolidayPayResponse getHolidayPayment(BigDecimal avgSalary, int numberHolidayDays) {
        if (!CalculatorRequestDataValidator.validateAvgSalary(avgSalary)) {
            throw new CalculatorException("Incorrect amount of average salary: should be >= 0");
        }

        if (!CalculatorRequestDataValidator.validateHolidayDays(numberHolidayDays)) {
            throw new CalculatorException("Incorrect number of holiday days: should be >= 0");
        }

        BigDecimal avgSalaryPerDay = avgSalary.divide(BigDecimal.valueOf(AVG_DAYS_PER_MONTH), 3, RoundingMode.HALF_EVEN);

        BigDecimal overallHolidayPay = avgSalaryPerDay.multiply(BigDecimal.valueOf(numberHolidayDays))
                .setScale( 3, RoundingMode.HALF_EVEN);

        BigDecimal taxDeduction = overallHolidayPay.multiply(BigDecimal.valueOf(TAX_PERCENT))
                .setScale(3, RoundingMode.HALF_UP);

        BigDecimal resultantHolidayPay = overallHolidayPay.subtract(taxDeduction)
                .setScale(2, RoundingMode.HALF_EVEN);

        return HolidayPayResponse.builder().
                responseMessage("Holiday payment: ").amountHolidayPay(resultantHolidayPay).build();
    }
}
