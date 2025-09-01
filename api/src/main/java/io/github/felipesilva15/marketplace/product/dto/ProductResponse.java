package io.github.felipesilva15.marketplace.product.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.felipesilva15.marketplace.product.enumerator.ProductionType;
import io.github.felipesilva15.marketplace.product.enumerator.UnitMeasurement;
import io.github.felipesilva15.marketplace.product.model.Brand;
import io.github.felipesilva15.marketplace.product.model.Category;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ProductResponse {
    private Long id;

    private String sku;

    private String name;

    private String description;

    private String observations;

    @JsonProperty("unit_measurement")
    private UnitMeasurement unitMeasurement;

    private BigDecimal price;

    private BigDecimal cost;

    @JsonProperty("net_weight")
    private BigDecimal netWeight;

    @JsonProperty("gross_weight")
    private BigDecimal grossWeight;

    private BigDecimal width;

    private BigDecimal height;

    private BigDecimal length;

    private String ean;

    @JsonProperty("minimum_stock")
    private BigDecimal minimumStock;

    @JsonProperty("maximum_stock")
    private BigDecimal maximumStock;

    @JsonProperty("production_type")
    private ProductionType productionType;

    private Brand brand;

    private Category category;

    private boolean active;

    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;
}
