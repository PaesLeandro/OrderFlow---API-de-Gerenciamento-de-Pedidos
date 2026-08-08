package com.portfolio.orderflow.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.orderflow.domain.Order;
import com.portfolio.orderflow.dto.CreateOrderRequest;
import com.portfolio.orderflow.patterns.facade.OrderFacade;

import jakarta.validation.Valid;

/**
 * Controller responsável pelos endpoints de pedidos.
 *
 * Recebe as requisições HTTP e delega a regra de negócio
 * para a Facade, mantendo esta camada focada apenas
 * na entrada e saída dos dados da API.
 */
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderFacade orderFacade;

    public OrderController(OrderFacade orderFacade) {
        this.orderFacade = orderFacade;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Order create(@Valid @RequestBody CreateOrderRequest request) {
        return orderFacade.create(request);
    }

    @GetMapping
    public List<Order> findAll() {
        return orderFacade.findAll();
    }

    @GetMapping("/{id}")
    public Order findById(@PathVariable Long id) {
        return orderFacade.findById(id);
    }
}