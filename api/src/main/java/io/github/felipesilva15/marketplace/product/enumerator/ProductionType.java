package io.github.felipesilva15.marketplace.product.enumerator;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.stream.Stream;

public enum ProductionType {
    OWN("P"),
    THIRD_PARTIES("T");

    @Getter
    @JsonValue
    private final String code;

    ProductionType(String code) {
        this.code = code;
    }

    @JsonCreator
    public static ProductionType fromCode(String code) {
        for (ProductionType productionType : ProductionType.values()) {
            if (productionType.getCode().equalsIgnoreCase(code.trim())) {
                return productionType;
            }
        }
        throw new IllegalArgumentException("Invalid code: " + code);
    }
}
