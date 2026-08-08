package com.portfolio.orderflow.patterns.chain;

import com.portfolio.orderflow.domain.Order;
import java.math.BigDecimal;

public class AmountValidationHandler extends OrderValidationHandler {

    @Override
    protected void check(Order order) {
        if (order.getAmount() == null || order.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("O valor do pedido deve ser maior que zero.");
        }
    }
}
