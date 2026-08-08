package com.portfolio.orderflow.patterns.strategy;

import java.math.BigDecimal;

public record PaymentResult(BigDecimal finalAmount, String message) {
}
