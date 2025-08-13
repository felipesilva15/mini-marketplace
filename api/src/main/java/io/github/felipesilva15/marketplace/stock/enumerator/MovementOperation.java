package io.github.felipesilva15.marketplace.stock.enumerator;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

public enum MovementOperation {
    INPUT("I"),
    OUTPUT("O");

    @Getter
    @JsonValue
    private final String code;

    MovementOperation(String code) {
        this.code = code;
    }

    @JsonCreator
    public static MovementOperation fromCode(String code) {
        for (MovementOperation movementOperation : MovementOperation.values()) {
            if (movementOperation.getCode().equalsIgnoreCase(code.trim())) {
                return movementOperation;
            }
        }
        throw new IllegalArgumentException("Invalid code: " + code);
    }
}
