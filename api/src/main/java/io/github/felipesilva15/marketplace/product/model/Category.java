package io.github.felipesilva15.marketplace.product.model;

import io.github.felipesilva15.marketplace.common.model.BaseModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "categories")
public class Category extends BaseModel {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 120)
    private String name;

    @Column
    private String description;
}
