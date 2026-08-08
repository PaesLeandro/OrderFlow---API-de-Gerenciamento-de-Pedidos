package com.portfolio.orderflow.patterns.chain;

import com.portfolio.orderflow.domain.Order;

public abstract class OrderValidationHandler {

    private OrderValidationHandler next;

    public OrderValidationHandler linkWith(OrderValidationHandler next) {
        this.next = next;
        return next;
    }

    public final void validate(Order order) {
        check(order);

        if (next != null) {
            next.validate(order);
        }
    }

    protected abstract void check(Order order);
}
