package io.github.felipesilva15.marketplace.order.dto;

import io.github.felipesilva15.marketplace.order.enumerator.OrderStatus;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
public class OrderDTO {
    private Long id;

    private Long userId;

    private UserDTO user;

    private String postalCode;

    private String street;

    private String locality;

    private String city;

    private String region;

    private String regionCode;

    private String number;

    private String complement;

    private Date orderDate;

    private OrderStatus status;

    private BigDecimal productsValue;

    private BigDecimal shippingCost;

    private BigDecimal total;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private List<OrderItemDTO> items;

    public void calculateTotal() {
        setTotal(getProductsValue().add(getShippingCost()));
    }

    public void calculateProductsValue() {
        setProductsValue(new BigDecimal(0));
    }

    public void totalize() {
        calculateProductsValue();
        calculateTotal();
    }
}
