package com.portfolio.orderflow.patterns.strategy;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.portfolio.orderflow.domain.PaymentType;

/**
 * Responsável por localizar a estratégia de pagamento
 * correspondente ao tipo informado no pedido.
 *
 * As estratégias são registradas automaticamente pelo
 * Spring e armazenadas em um mapa para facilitar a busca.
 */
@Component
public class PaymentStrategyResolver {

    private final Map<PaymentType, PaymentStrategy> strategies =
            new EnumMap<>(PaymentType.class);

    public PaymentStrategyResolver(List<PaymentStrategy> paymentStrategies) {
        paymentStrategies.forEach(strategy ->
                strategies.put(strategy.supports(), strategy));
    }

    /**
     * Retorna a estratégia correspondente ao tipo
     * de pagamento solicitado.
     *
     * @param paymentType tipo de pagamento informado
     * @return implementação da estratégia de pagamento
     * @throws IllegalArgumentException quando o tipo
     *         de pagamento não estiver implementado.
     */
    public PaymentStrategy resolve(PaymentType paymentType) {

        PaymentStrategy strategy = strategies.get(paymentType);

        if (strategy == null) {
            throw new IllegalArgumentException(
                    "Forma de pagamento não suportada: " + paymentType
            );
        }

        return strategy;
    }
}