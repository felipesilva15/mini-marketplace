package io.github.felipesilva15.marketplace.product.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class BrandRequest {
    @NotBlank
    @Size(max = 120)
    private String name;
}
