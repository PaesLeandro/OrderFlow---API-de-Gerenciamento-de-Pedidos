package com.portfolio.orderflow.patterns.strategy;

import com.portfolio.orderflow.domain.PaymentType;
import java.math.BigDecimal;

public interface PaymentStrategy {

    PaymentType supports();

    PaymentResult pay(BigDecimal amount);
}
