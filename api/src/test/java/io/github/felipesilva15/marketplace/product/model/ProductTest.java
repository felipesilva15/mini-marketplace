package io.github.felipesilva15.marketplace.product.model;

import io.github.felipesilva15.marketplace.common.model.BaseModel;
import io.github.felipesilva15.marketplace.product.enumerator.ProductionType;
import io.github.felipesilva15.marketplace.product.enumerator.UnitMeasurement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ProductTest {
    private Product product;

    @BeforeEach
    void setUp() {
        product = new Product(
                1L,
                "PRD0001",
                "Product test",
                "Description test",
                "Observations test",
                UnitMeasurement.UNIT,
                new BigDecimal("159.9"),
                new BigDecimal("675"),
                new BigDecimal("775"),
                new BigDecimal("28"),
                new BigDecimal("15"),
                new BigDecimal("1"),
                "7894418120176",
                new BigDecimal("3"),
                new BigDecimal("10"),
                ProductionType.THIRD_PARTIES,
                new Brand(),
                new Category(),
                true
        );
    }

    @Test
    @DisplayName("Should extends from BaseModel")
    void shouldExtendsFromBaseModel() {
        assertInstanceOf(BaseModel.class, product);
    }

    @Test
    @DisplayName("Should create product with correct data")
    void shouldCreateProductWithCorrectData() {
        assertNotNull(product);
        assertEquals(1L, product.getId());
        assertEquals("Product test", product.getName());
    }

    @Test
    @DisplayName("Should allow properties update")
    void shouldAllowPropertiesUpdate() {
        product.setName("new name");

        assertEquals("new name", product.getName());
    }

    @Test
    @DisplayName("Should return true for equal objects")
    void shouldReturnTrueForEqualObjects() {
        Product secondProduct = new Product(
                1L,
                "PRD0001",
                "Product test",
                "Description test",
                "Observations test",
                UnitMeasurement.UNIT,
                new BigDecimal("159.9"),
                new BigDecimal("675"),
                new BigDecimal("775"),
                new BigDecimal("28"),
                new BigDecimal("15"),
                new BigDecimal("1"),
                "7894418120176",
                new BigDecimal("3"),
                new BigDecimal("10"),
                ProductionType.THIRD_PARTIES,
                new Brand(),
                new Category(),
                true
        );

        assertEquals(product, secondProduct);
        assertEquals(product, product);
    }

    @Test
    @DisplayName("Should return false for different objects")
    void shouldReturnFalseForDifferentObjects() {
        Product secondProduct = new Product(
                1L,
                "PRD0001",
                "Different product test",
                "Description test",
                "Observations test",
                UnitMeasurement.UNIT,
                new BigDecimal("159.9"),
                new BigDecimal("675"),
                new BigDecimal("775"),
                new BigDecimal("28"),
                new BigDecimal("15"),
                new BigDecimal("1"),
                "7894418120176",
                new BigDecimal("3"),
                new BigDecimal("10"),
                ProductionType.THIRD_PARTIES,
                new Brand(),
                new Category(),
                true
        );

        assertNotEquals(null, product);
        assertNotEquals(new Object(), product);
        assertNotEquals(secondProduct, product);
    }

    @Test
    @DisplayName("Hash codes should be equal for equal objects")
    void hashCodesShouldBeEqualForEqualObjects() {
        Product secondProduct = new Product(
                1L,
                "PRD0001",
                "Product test",
                "Description test",
                "Observations test",
                UnitMeasurement.UNIT,
                new BigDecimal("159.9"),
                new BigDecimal("675"),
                new BigDecimal("775"),
                new BigDecimal("28"),
                new BigDecimal("15"),
                new BigDecimal("1"),
                "7894418120176",
                new BigDecimal("3"),
                new BigDecimal("10"),
                ProductionType.THIRD_PARTIES,
                new Brand(),
                new Category(),
                true
        );

        assertEquals(product.hashCode(), secondProduct.hashCode());
    }

    @Test
    @DisplayName("Should create product with no args constructor")
    void shouldCreateProductWithNoArgsConstructor() {
        Product testProduct = new Product();

        assertNotNull(testProduct);
        assertNull(testProduct.getId());
        assertNull(testProduct.getName());
    }
}
