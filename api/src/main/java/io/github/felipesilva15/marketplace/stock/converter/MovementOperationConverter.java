package io.github.felipesilva15.marketplace.stock.converter;

import io.github.felipesilva15.marketplace.stock.enumerator.MovementOperation;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class MovementOperationConverter implements AttributeConverter<MovementOperation, String> {
    @Override
    public String convertToDatabaseColumn(MovementOperation attribute) {
        if (attribute == null) {
            return null;
        }

        return attribute.getCode();
    }

    @Override
    public MovementOperation convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }

        return MovementOperation.fromCode(dbData);
    }
}
