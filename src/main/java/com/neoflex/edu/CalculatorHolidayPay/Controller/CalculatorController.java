package com.neoflex.edu.CalculatorHolidayPay.Controller;

import com.neoflex.edu.CalculatorHolidayPay.Model.HolidayPayResponse;
import com.neoflex.edu.CalculatorHolidayPay.Service.Implmnt.CalculatorServiceImplement;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;


@Validated
@RestController
@RequestMapping()
@RequiredArgsConstructor
public class CalculatorController {
    @Autowired
    private final CalculatorServiceImplement calculatorService;

    @GetMapping(value = "/calculate", params = {"avgSalary", "numberHolidayDays"})
    public ResponseEntity<HolidayPayResponse> getHolidayPay(@RequestParam BigDecimal avgSalary,
                                                            @RequestParam int numberHolidayDays){
        return ResponseEntity.ok().body(calculatorService.getHolidayPayment(avgSalary, numberHolidayDays));
    }
}
