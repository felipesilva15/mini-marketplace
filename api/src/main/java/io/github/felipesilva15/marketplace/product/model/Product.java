package io.github.felipesilva15.marketplace.product.model;

import io.github.felipesilva15.marketplace.auth.model.User;
import io.github.felipesilva15.marketplace.common.model.BaseModel;
import io.github.felipesilva15.marketplace.product.converter.ProductionTypeConverter;
import io.github.felipesilva15.marketplace.product.enumerator.ProductionType;
import io.github.felipesilva15.marketplace.product.enumerator.UnitMeasurement;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product extends BaseModel {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 40, nullable = false)
    private String sku;

    @Column(nullable = false)
    private String name;

    @Lob
    private String description;

    @Column
    private String observations;

    @Column(name = "unit_measurement", length = 3)
    private UnitMeasurement unitMeasurement;

    @Column(precision = 12, scale = 2)
    private BigDecimal price;

    @Column(precision = 12, scale = 2)
    private BigDecimal cost;

    @Column(name = "net_weight", precision = 10, scale = 3)
    private BigDecimal netWeight;

    @Column(name = "gross_weight", precision = 10, scale = 3)
    private BigDecimal grossWeight;

    @Column(precision = 8, scale = 2)
    private BigDecimal width;

    @Column(precision = 8, scale = 2)
    private BigDecimal height;

    @Column(precision = 8, scale = 2)
    private BigDecimal length;

    @Column(length = 14)
    private String ean;

    @Column(name = "minimum_stock", precision = 10, scale = 2)
    private BigDecimal minimumStock;

    @Column(name = "maximum_stock", precision = 10, scale = 2)
    private BigDecimal maximumStock;

    @Column(name = "production_type", length = 2)
    private ProductionType productionType;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Column
    private boolean active;
}
