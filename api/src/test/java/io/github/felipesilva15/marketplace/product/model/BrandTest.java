package io.github.felipesilva15.marketplace.product.model;

import io.github.felipesilva15.marketplace.common.model.BaseModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BrandTest {
    private Brand brand;

    @BeforeEach
    void setUp() {
        brand = new Brand(
                1L,
                "Brand test"
        );
    }

    @Test
    @DisplayName("Should extends from BaseModel")
    void shouldExtendsFromBaseModel() {
        assertInstanceOf(BaseModel.class, brand);
    }

    @Test
    @DisplayName("Should create brand with correct data")
    void shouldCreateBrandWithCorrectData() {
        assertNotNull(brand);
        assertEquals(1L, brand.getId());
        assertEquals("Brand test", brand.getName());
    }

    @Test
    @DisplayName("Should allow properties update")
    void shouldAllowPropertiesUpdate() {
        brand.setName("new name");

        assertEquals("new name", brand.getName());
    }

    @Test
    @DisplayName("Should return true for equal objects")
    void shouldReturnTrueForEqualObjects() {
        Brand secondBrand = new Brand(
                1L,
                "Brand test"
        );

        assertEquals(brand, secondBrand);
        assertEquals(brand, brand);
    }

    @Test
    @DisplayName("Should return false for different objects")
    void shouldReturnFalseForDifferentObjects() {
        Brand secondBrand = new Brand(
                1L,
                "Different brand test"
        );

        assertNotEquals(null, brand);
        assertNotEquals(new Object(), brand);
        assertNotEquals(secondBrand, brand);
    }

    @Test
    @DisplayName("Hash codes should be equal for equal objects")
    void hashCodesShouldBeEqualForEqualObjects() {
        Brand secondBrand = new Brand(
                1L,
                "Brand test"
        );

        assertEquals(brand.hashCode(), secondBrand.hashCode());
    }

    @Test
    @DisplayName("Should create brand with no args constructor")
    void shouldCreateBrandWithNoArgsConstructor() {
        Brand testBrand = new Brand();

        assertNotNull(testBrand);
        assertNull(testBrand.getId());
        assertNull(testBrand.getName());
    }
}
