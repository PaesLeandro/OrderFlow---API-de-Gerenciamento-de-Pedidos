package com.portfolio.orderflow.patterns.strategy;

import com.portfolio.orderflow.domain.PaymentType;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class CreditCardPaymentStrategy implements PaymentStrategy {

    @Override
    public PaymentType supports() {
        return PaymentType.CREDIT_CARD;
    }

    @Override
    public PaymentResult pay(BigDecimal amount) {
        BigDecimal finalAmount = amount.setScale(2, RoundingMode.HALF_UP);
        return new PaymentResult(finalAmount, "Pagamento com cartão de crédito aprovado.");
    }
}
