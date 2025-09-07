package io.github.felipesilva15.marketplace.order.model;

import io.github.felipesilva15.marketplace.common.model.BaseModel;
import io.github.felipesilva15.marketplace.order.enumerator.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order extends BaseModel {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "postal_code", length = 8)
    private String postalCode;

    @Column(length = 80)
    private String street;

    @Column(length = 40)
    private String locality;

    @Column(length = 60)
    private String city;

    @Column(length = 40)
    private String region;

    @Column(name = "region_code", length = 2)
    private String regionCode;

    @Column(length = 10)
    private String number;

    @Column(length = 120)
    private String complement;

    @Column(name = "order_date")
    private Date orderDate;

    @Column(length = 1)
    private OrderStatus status;

    @Column(name = "products_value", precision = 12, scale = 2)
    private BigDecimal productsValue;

    @Column(name = "shipping_cost", precision = 12, scale = 2)
    private BigDecimal shippingCost;

    @Column(precision = 12, scale = 2)
    private BigDecimal total;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> items;
}
