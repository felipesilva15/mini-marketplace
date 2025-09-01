package io.github.felipesilva15.marketplace.stock.model;

import io.github.felipesilva15.marketplace.common.model.BaseModel;
import io.github.felipesilva15.marketplace.stock.enumerator.MovementOperation;
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
@Table(name = "movements")
public class Movement extends BaseModel {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_id")
    private Long productId;

    @ManyToOne
    @JoinColumn(name = "deposit_id")
    private Deposit deposit;

    @Column(length = 1)
    private MovementOperation operation;

    @Column(precision = 12, scale = 2)
    private BigDecimal quantity;

    @Column(precision = 12, scale = 2)
    private BigDecimal price;

    @Column(precision = 12, scale = 2)
    private BigDecimal cost;

    @Lob
    private String observations;
}
