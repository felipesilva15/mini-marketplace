package io.github.felipesilva15.marketplace.order.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.felipesilva15.marketplace.auth.model.User;
import io.github.felipesilva15.marketplace.order.enumerator.OrderStatus;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
public class OrderResponse {
    private Long id;

    private User user;

    @JsonProperty("postal_code")
    private String postalCode;

    private String street;

    private String locality;

    private String city;

    private String region;

    @JsonProperty("region_code")
    private String regionCode;

    private String number;

    private String complement;

    @JsonProperty("order_date")
    private Date orderDate;

    private OrderStatus status;

    @JsonProperty("products_value")
    private BigDecimal productsValue;

    @JsonProperty("shipping_cost")
    private BigDecimal shippingCost;

    private BigDecimal total;

    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;

    private List<OrderItemResponse> items;
}
