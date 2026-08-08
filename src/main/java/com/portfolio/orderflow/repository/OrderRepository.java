package com.portfolio.orderflow.repository;

import com.portfolio.orderflow.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
