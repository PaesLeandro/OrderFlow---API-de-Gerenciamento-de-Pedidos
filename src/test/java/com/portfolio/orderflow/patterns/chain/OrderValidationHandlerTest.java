package com.portfolio.orderflow.patterns.chain;

import com.portfolio.orderflow.domain.Order;
import com.portfolio.orderflow.domain.PaymentType;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class OrderValidationHandlerTest {

    private OrderValidationHandler chain() {
        OrderValidationHandler customer = new CustomerValidationHandler();
        customer.linkWith(new AmountValidationHandler())
                .linkWith(new PaymentTypeValidationHandler());
        return customer;
    }

    @Test
    void shouldValidateAValidOrder() {
        Order order = new Order();
        order.setCustomerName("Leandro");
        order.setCustomerEmail("leandro@example.com");
        order.setAmount(new BigDecimal("100.00"));
        order.setPaymentType(PaymentType.PIX);

        assertDoesNotThrow(() -> chain().validate(order));
    }

    @Test
    void shouldRejectInvalidAmount() {
        Order order = new Order();
        order.setCustomerName("Leandro");
        order.setCustomerEmail("leandro@example.com");
        order.setAmount(BigDecimal.ZERO);
        order.setPaymentType(PaymentType.PIX);

        IllegalArgumentException ex =
                assertThrows(IllegalArgumentException.class, () -> chain().validate(order));

        assertEquals("O valor do pedido deve ser maior que zero.", ex.getMessage());
    }
}
