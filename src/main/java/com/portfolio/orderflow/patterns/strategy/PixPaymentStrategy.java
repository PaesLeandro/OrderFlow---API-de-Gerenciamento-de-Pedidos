package com.portfolio.orderflow.patterns.strategy;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Component;

import com.portfolio.orderflow.domain.PaymentType;

/**
 * Estratégia responsável pelo processamento de pagamentos via PIX.
 *
 * Nesta implementação é aplicado um desconto de 5% sobre
 * o valor total do pedido.
 */
@Component
public class PixPaymentStrategy implements PaymentStrategy {

    private static final BigDecimal DISCOUNT = new BigDecimal("0.95");

    @Override
    public PaymentType supports() {
        return PaymentType.PIX;
    }

    @Override
    public PaymentResult pay(BigDecimal amount) {

        // Calcula o valor final aplicando o desconto do PIX.
        BigDecimal finalAmount = amount.multiply(DISCOUNT)
                .setScale(2, RoundingMode.HALF_UP);

        return new PaymentResult(
                finalAmount,
                "Pagamento via PIX aprovado com 5% de desconto."
        );
    }
}