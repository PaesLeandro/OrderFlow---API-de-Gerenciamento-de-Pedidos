package com.portfolio.orderflow.patterns.strategy;

import com.portfolio.orderflow.domain.PaymentType;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class PixPaymentStrategy implements PaymentStrategy {

    private static final BigDecimal DISCOUNT = new BigDecimal("0.95");

    @Override
    public PaymentType supports() {
        return PaymentType.PIX;
    }

    @Override
    public PaymentResult pay(BigDecimal amount) {
        BigDecimal finalAmount = amount.multiply(DISCOUNT).setScale(2, RoundingMode.HALF_UP);
        return new PaymentResult(finalAmount, "Pagamento via PIX aprovado com 5% de desconto.");
    }
}
