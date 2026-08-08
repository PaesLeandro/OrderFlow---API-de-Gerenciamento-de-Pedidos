package com.portfolio.orderflow.controller;

import com.portfolio.orderflow.domain.Order;
import com.portfolio.orderflow.dto.CreateOrderRequest;
import com.portfolio.orderflow.patterns.facade.OrderFacade;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
