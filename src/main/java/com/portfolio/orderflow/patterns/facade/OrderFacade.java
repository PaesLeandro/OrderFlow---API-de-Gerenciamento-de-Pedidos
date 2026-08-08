package com.portfolio.orderflow.patterns.facade;

import java.util.List;

import org.springframework.stereotype.Service;

import com.portfolio.orderflow.domain.Order;
import com.portfolio.orderflow.domain.OrderStatus;
import com.portfolio.orderflow.dto.CreateOrderRequest;
import com.portfolio.orderflow.patterns.chain.OrderValidationHandler;
import com.portfolio.orderflow.patterns.strategy.PaymentResult;
import com.portfolio.orderflow.patterns.strategy.PaymentStrategy;
import com.portfolio.orderflow.patterns.strategy.PaymentStrategyResolver;
import com.portfolio.orderflow.repository.OrderRepository;

/**
 * Centraliza o fluxo de criação dos pedidos.
 *
 * A Facade mantém o Controller mais simples, concentrando
 * em um único ponto as validações, a escolha da estratégia
 * de pagamento e a persistência dos dados.
 */
@Service
public class OrderFacade {

    private final OrderRepository orderRepository;
    private final OrderValidationHandler validationChain;
    private final PaymentStrategyResolver paymentStrategyResolver;

    public OrderFacade(
            OrderRepository orderRepository,
            OrderValidationHandler validationChain,
            PaymentStrategyResolver paymentStrategyResolver
    ) {
        this.orderRepository = orderRepository;
        this.validationChain = validationChain;
        this.paymentStrategyResolver = paymentStrategyResolver;
    }

    /**
     * Executa o fluxo de criação de um pedido.
     *
     * Primeiro valida os dados recebidos, depois seleciona
     * a estratégia correspondente ao tipo de pagamento,
     * processa o valor final e salva o pedido.
     */
    public Order create(CreateOrderRequest request) {
        Order order = new Order();
        order.setCustomerName(request.customerName());
        order.setCustomerEmail(request.customerEmail());
        order.setAmount(request.amount());
        order.setPaymentType(request.paymentType());
        order.setStatus(OrderStatus.CREATED);

        validationChain.validate(order);

        PaymentStrategy strategy =
                paymentStrategyResolver.resolve(order.getPaymentType());

        PaymentResult paymentResult =
                strategy.pay(order.getAmount());

        order.setFinalAmount(paymentResult.finalAmount());
        order.setPaymentMessage(paymentResult.message());
        order.setStatus(OrderStatus.PAID);

        return orderRepository.save(order);
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Pedido não encontrado: " + id
                        )
                );
    }
}