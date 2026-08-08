package com.portfolio.orderflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

/**
 * Classe principal responsável pela inicialização da aplicação.
 *
 * O OrderFlow é uma API REST desenvolvida para demonstrar a
 * aplicação de Design Patterns utilizando Spring Boot.
 */
@SpringBootApplication
@OpenAPIDefinition(
    info = @Info(
        title = "OrderFlow API",
        version = "1.0.0",
        description = "API REST para gerenciamento de pedidos utilizando Spring Boot e Design Patterns."
    )
)
public class OrderFlowApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderFlowApplication.class, args);
    }
}