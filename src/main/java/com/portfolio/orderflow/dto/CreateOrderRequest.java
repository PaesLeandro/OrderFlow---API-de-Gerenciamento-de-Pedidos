package com.portfolio.orderflow.dto;

import com.portfolio.orderflow.domain.PaymentType;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public record CreateOrderRequest(
        @NotBlank(message = "Nome do cliente é obrigatório")
        String customerName,

        @NotBlank(message = "E-mail é obrigatório")
        @Email(message = "E-mail inválido")
        String customerEmail,

        @NotNull(message = "Valor é obrigatório")
        @DecimalMin(value = "0.01", message = "Valor deve ser maior que zero")
        BigDecimal amount,

        @NotNull(message = "Forma de pagamento é obrigatória")
        PaymentType paymentType
) {}
