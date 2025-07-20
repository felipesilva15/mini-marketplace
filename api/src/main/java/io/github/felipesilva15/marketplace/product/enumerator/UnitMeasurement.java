package io.github.felipesilva15.marketplace.product.enumerator;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.stream.Stream;

public enum UnitMeasurement {
    PART("PC"),
    PACKAGE("PT"),
    UNIT("UN"),
    KILOGRAM("KG"),
    GRAM("GR"),
    LITER("LT"),
    MILLILITER("ML"),
    METER("MT"),
    MILLIMETER("MM"),
    CENTIMETER("CM");

    @Getter
    @JsonValue
    private final String code;

    UnitMeasurement(String code) {
        this.code = code;
    }

    @JsonCreator
    public static UnitMeasurement fromCode(String code) {
        for (UnitMeasurement unit : UnitMeasurement.values()) {
            if (unit.getCode().equalsIgnoreCase(code.trim())) {
                return unit;
            }
        }
        throw new IllegalArgumentException("Invalid code: " + code);
    }
}
