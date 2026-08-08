package com.portfolio.orderflow.patterns.strategy;

import com.portfolio.orderflow.domain.PaymentType;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

@Component
public class PaymentStrategyResolver {

    private final Map<PaymentType, PaymentStrategy> strategies = new EnumMap<>(PaymentType.class);

    public PaymentStrategyResolver(List<PaymentStrategy> paymentStrategies) {
        paymentStrategies.forEach(strategy -> strategies.put(strategy.supports(), strategy));
    }

    public PaymentStrategy resolve(PaymentType paymentType) {
        PaymentStrategy strategy = strategies.get(paymentType);

        if (strategy == null) {
            throw new IllegalArgumentException("Forma de pagamento não suportada: " + paymentType);
        }

        return strategy;
    }
}
