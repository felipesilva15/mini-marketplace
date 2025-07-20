package io.github.felipesilva15.marketplace.product.converter;

import io.github.felipesilva15.marketplace.product.enumerator.ProductionType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class ProductionTypeConverter implements AttributeConverter<ProductionType, String> {
    @Override
    public String convertToDatabaseColumn(ProductionType attribute) {
        if (attribute == null) {
            return null;
        }

        return attribute.getCode();
    }

    @Override
    public ProductionType convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }

        return ProductionType.fromCode(dbData);
    }
}
