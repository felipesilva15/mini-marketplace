package io.github.felipesilva15.marketplace.stock.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.felipesilva15.marketplace.product.model.Product;
import io.github.felipesilva15.marketplace.stock.enumerator.MovementOperation;
import io.github.felipesilva15.marketplace.stock.model.Deposit;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class MovementDTO {
    private Long id;

    private Product product;

    private Deposit deposit;

    private MovementOperation operation;

    private BigDecimal price;

    private BigDecimal cost;

    private String observations;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
