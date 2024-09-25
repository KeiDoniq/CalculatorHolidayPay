package com.neoflex.edu.CalculatorHolidayPay.Model;

import lombok.*;

import java.math.BigDecimal;


@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class HolidayPayResponse {
    String responseMessage;
    BigDecimal amountHolidayPay;
}
