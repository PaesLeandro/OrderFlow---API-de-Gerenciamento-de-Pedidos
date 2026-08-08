package com.portfolio.orderflow.patterns.strategy;

import com.portfolio.orderflow.domain.PaymentType;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class BoletoPaymentStrategy implements PaymentStrategy {

    private static final BigDecimal FEE = new BigDecimal("2.50");

    @Override
    public PaymentType supports() {
        return PaymentType.BOLETO;
    }

    @Override
    public PaymentResult pay(BigDecimal amount) {
        BigDecimal finalAmount = amount.add(FEE).setScale(2, RoundingMode.HALF_UP);
        return new PaymentResult(finalAmount, "Boleto gerado com taxa operacional de R$ 2,50.");
    }
}
