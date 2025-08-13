package io.github.felipesilva15.marketplace.stock.dto;

import io.github.felipesilva15.marketplace.stock.enumerator.MovementOperation;
import io.github.felipesilva15.marketplace.stock.model.Deposit;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class MovementRequest {
    @NotNull
    private MovementProductDTO product;

    @NotNull
    private Deposit deposit;

    @NotBlank
    private MovementOperation operation;

    @Positive
    private BigDecimal price;

    @Positive
    private BigDecimal cost;

    private String observations;
}
