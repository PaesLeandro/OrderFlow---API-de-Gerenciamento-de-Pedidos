package com.portfolio.orderflow.patterns.chain;

import com.portfolio.orderflow.domain.Order;

public class PaymentTypeValidationHandler extends OrderValidationHandler {

    @Override
    protected void check(Order order) {
        if (order.getPaymentType() == null) {
            throw new IllegalArgumentException("Forma de pagamento obrigatória.");
        }
    }
}
