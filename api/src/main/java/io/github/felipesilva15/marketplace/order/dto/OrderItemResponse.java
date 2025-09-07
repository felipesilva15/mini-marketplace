package io.github.felipesilva15.marketplace.order.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class OrderItemResponse {
    private Long id;

    private ProductDTO product;

    private BigDecimal quantity;

    private BigDecimal price;

    private BigDecimal total;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
