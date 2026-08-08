package com.portfolio.orderflow.patterns.chain;

import com.portfolio.orderflow.domain.Order;

public class CustomerValidationHandler extends OrderValidationHandler {

    @Override
    protected void check(Order order) {
        if (order.getCustomerName() == null || order.getCustomerName().isBlank()) {
            throw new IllegalArgumentException("Cliente inválido.");
        }

        if (order.getCustomerEmail() == null || !order.getCustomerEmail().contains("@")) {
            throw new IllegalArgumentException("E-mail do cliente inválido.");
        }
    }
}
