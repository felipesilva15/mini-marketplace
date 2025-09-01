package io.github.felipesilva15.marketplace.stock.dto;

import io.github.felipesilva15.marketplace.stock.enumerator.MovementOperation;
import io.github.felipesilva15.marketplace.stock.model.Deposit;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class MovementRequest {
    @NotNull
    private MovementProductDTO product;

    @NotNull
    private Deposit deposit;

    private MovementOperation operation;

    @Positive
    @NotNull
    private BigDecimal quantity;

    @Positive
    private BigDecimal price;

    @Positive
    private BigDecimal cost;

    private String observations;
}
