package io.github.felipesilva15.marketplace.order.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItemRequest {
    @NotNull
    private OrderItemProductDTO product;

    @Positive
    private BigDecimal quantity;

    @PositiveOrZero
    private BigDecimal price;
}
