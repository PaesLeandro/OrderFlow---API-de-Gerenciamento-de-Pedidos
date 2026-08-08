package com.portfolio.orderflow.patterns.strategy;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PixPaymentStrategyTest {

    @Test
    void shouldApplyFivePercentDiscount() {
        PixPaymentStrategy strategy = new PixPaymentStrategy();

        PaymentResult result = strategy.pay(new BigDecimal("100.00"));

        assertEquals(new BigDecimal("95.00"), result.finalAmount());
    }
}
