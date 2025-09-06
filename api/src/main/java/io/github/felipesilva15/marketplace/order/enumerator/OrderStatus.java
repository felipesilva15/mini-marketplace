package io.github.felipesilva15.marketplace.order.enumerator;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

public enum OrderStatus {
    REGISTERED("R"),
    IN_TRANSIT("T"),
    FINALIZED("F");

    @Getter
    @JsonValue
    private final String code;

    OrderStatus(String code) {
        this.code = code;
    }

    @JsonCreator
    public static OrderStatus fromCode(String code) {
        for (OrderStatus orderStatus : OrderStatus.values()) {
            if (orderStatus.getCode().equalsIgnoreCase(code.trim())) {
                return orderStatus;
            }
        }
        throw new IllegalArgumentException("Invalid code: " + code);
    }
}
