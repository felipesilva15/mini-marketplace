package io.github.felipesilva15.marketplace.stock.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class DepositRequest {
    @NotBlank
    @Size(max = 120)
    private String name;

    @NotNull
    private boolean active;
}
