package com.portfolio.orderflow.config;

import com.portfolio.orderflow.patterns.chain.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ValidationChainConfig {

    @Bean
    public OrderValidationHandler orderValidationChain() {
        OrderValidationHandler customer = new CustomerValidationHandler();
        OrderValidationHandler amount = new AmountValidationHandler();
        OrderValidationHandler paymentType = new PaymentTypeValidationHandler();

        customer.linkWith(amount).linkWith(paymentType);
        return customer;
    }
}
