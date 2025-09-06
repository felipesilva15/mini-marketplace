package io.github.felipesilva15.marketplace.order.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.felipesilva15.marketplace.order.enumerator.OrderStatus;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class OrderRequest {
    @NotNull
    private OrderUserDTO user;

    @NotNull
    @JsonProperty("postal_code")
    private String postalCode;

    @NotNull
    private String street;

    @NotNull
    private String locality;

    @NotNull
    private String city;

    @NotNull
    private String region;

    @NotNull
    @JsonProperty("region_code")
    private String regionCode;

    @NotNull
    private String number;

    @NotNull
    private String complement;

    @NotNull
    @JsonProperty("order_date")
    private Date orderDate;

    private OrderStatus status;

    @PositiveOrZero
    @JsonProperty("shipping_cost")
    private BigDecimal shippingCost;
}
