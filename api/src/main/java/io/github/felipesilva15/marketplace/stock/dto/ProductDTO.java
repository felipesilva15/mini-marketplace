package io.github.felipesilva15.marketplace.stock.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.felipesilva15.marketplace.product.enumerator.ProductionType;
import io.github.felipesilva15.marketplace.product.enumerator.UnitMeasurement;
import io.github.felipesilva15.marketplace.product.model.Brand;
import io.github.felipesilva15.marketplace.product.model.Category;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ProductDTO {
    private Long id;

    private String sku;

    private String name;

    @JsonProperty("unit_measurement")
    private UnitMeasurement unitMeasurement;

    private BigDecimal price;

    private BigDecimal cost;

    private String ean;

    private Brand brand;

    private Category category;

    private boolean active;
}
