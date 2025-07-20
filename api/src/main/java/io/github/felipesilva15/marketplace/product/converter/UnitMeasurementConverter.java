package io.github.felipesilva15.marketplace.product.converter;

import io.github.felipesilva15.marketplace.product.enumerator.UnitMeasurement;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class UnitMeasurementConverter implements AttributeConverter<UnitMeasurement, String> {
    @Override
    public String convertToDatabaseColumn(UnitMeasurement attribute) {
        if (attribute == null) {
            return null;
        }

        return attribute.getCode();
    }

    @Override
    public UnitMeasurement convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }

        return UnitMeasurement.fromCode(dbData);
    }
}
