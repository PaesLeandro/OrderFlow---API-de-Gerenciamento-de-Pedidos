package com.portfolio.orderflow.patterns.chain;

import com.portfolio.orderflow.domain.Order;

/**
 * Implementação base do padrão Chain of Responsibility.
 *
 * Cada etapa da cadeia é responsável por validar
 * uma regra específica antes que o pedido seja processado.
 */
public abstract class OrderValidationHandler {

    private OrderValidationHandler next;

    /**
     * Define o próximo elemento da cadeia de validação.
     *
     * Permite encadear novas regras mantendo o fluxo
     * desacoplado e de fácil manutenção.
     */
    public OrderValidationHandler linkWith(OrderValidationHandler next) {
        this.next = next;
        return next;
    }

    /**
     * Inicia a execução da cadeia de validações.
     * Caso a validação atual seja concluída com sucesso,
     * o processamento segue para a próxima etapa.
     */
    public final void validate(Order order) {
        check(order);

        if (next != null) {
            next.validate(order);
        }
    }

    /**
     * Cada implementação deve validar uma regra
     * específica do pedido.
     */
    protected abstract void check(Order order);
}