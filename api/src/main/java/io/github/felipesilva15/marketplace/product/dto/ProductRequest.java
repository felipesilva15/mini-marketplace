package io.github.felipesilva15.marketplace.product.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.felipesilva15.marketplace.product.enumerator.ProductionType;
import io.github.felipesilva15.marketplace.product.enumerator.UnitMeasurement;
import io.github.felipesilva15.marketplace.product.model.Brand;
import io.github.felipesilva15.marketplace.product.model.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductRequest {
    @NotBlank
    @Size(min = 3, max = 40)
    private String sku;

    @NotBlank
    @Size(min = 2, max = 255)
    private String name;

    private String description;

    private String observations;

    @JsonProperty("unit_measurement")
    private UnitMeasurement unitMeasurement;

    @PositiveOrZero
    private BigDecimal price;

    @JsonProperty("net_weight")
    @PositiveOrZero
    private BigDecimal netWeight;

    @JsonProperty("gross_weight")
    @PositiveOrZero
    private BigDecimal grossWeight;

    @PositiveOrZero
    private BigDecimal width;

    @PositiveOrZero
    private BigDecimal height;

    @PositiveOrZero
    private BigDecimal length;

    @Size(min = 11, max = 14)
    private String ean;

    @JsonProperty("minimum_stock")
    @PositiveOrZero
    private BigDecimal minimumStock;

    @JsonProperty("maximum_stock")
    @PositiveOrZero
    private BigDecimal maximumStock;

    @JsonProperty("production_type")
    private ProductionType productionType;

    private Brand brand;

    private Category category;

    private boolean active;
}
