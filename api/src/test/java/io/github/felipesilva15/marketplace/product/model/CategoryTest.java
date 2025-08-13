package io.github.felipesilva15.marketplace.product.model;

import io.github.felipesilva15.marketplace.common.model.BaseModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CategoryTest {
    private Category category;

    @BeforeEach
    void setUp() {
        category = new Category(
                1L,
                "Category test",
                "Description test"
        );
    }

    @Test
    @DisplayName("Should extends from BaseModel")
    void shouldExtendsFromBaseModel() {
        assertInstanceOf(BaseModel.class, category);
    }

    @Test
    @DisplayName("Should create category with correct data")
    void shouldCreateCategoryWithCorrectData() {
        assertNotNull(category);
        assertEquals(1L, category.getId());
        assertEquals("Category test", category.getName());
    }

    @Test
    @DisplayName("Should allow properties update")
    void shouldAllowPropertiesUpdate() {
        category.setName("new name");

        assertEquals("new name", category.getName());
    }

    @Test
    @DisplayName("Should return true for equal objects")
    void shouldReturnTrueForEqualObjects() {
        Category secondCategory = new Category(
                1L,
                "Category test",
                "Description test"
        );

        assertEquals(category, secondCategory);
        assertEquals(category, category);
    }

    @Test
    @DisplayName("Should return false for different objects")
    void shouldReturnFalseForDifferentObjects() {
        Category secondCategory = new Category(
                1L,
                "Different category test",
                "Description test"
        );

        assertNotEquals(null, category);
        assertNotEquals(new Object(), category);
        assertNotEquals(secondCategory, category);
    }

    @Test
    @DisplayName("Hash codes should be equal for equal objects")
    void hashCodesShouldBeEqualForEqualObjects() {
        Category secondCategory = new Category(
                1L,
                "Category test",
                "Description test"
        );

        assertEquals(category.hashCode(), secondCategory.hashCode());
    }

    @Test
    @DisplayName("Should create category with no args constructor")
    void shouldCreateCategoryWithNoArgsConstructor() {
        Category testCategory = new Category();

        assertNotNull(testCategory);
        assertNull(testCategory.getId());
        assertNull(testCategory.getName());
    }
}
