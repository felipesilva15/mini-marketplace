package io.github.felipesilva15.marketplace.product.enumerator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductionTypeTest {
    @Test
    @DisplayName("Should have correct codes")
    void shouldHaveCorrectCodes() {
        assertEquals("P", ProductionType.OWN.getCode());
        assertEquals("T", ProductionType.THIRD_PARTIES.getCode());
    }

    @Test
    @DisplayName("Should return correct production type valid code")
    void shouldReturnCorrectProductionTypeFromValidCode() {
        assertEquals(ProductionType.OWN, ProductionType.fromCode("P"));
        assertEquals(ProductionType.OWN, ProductionType.fromCode("p"));
        assertEquals(ProductionType.OWN, ProductionType.fromCode(" P "));
        assertEquals(ProductionType.OWN, ProductionType.fromCode(" p "));

        assertEquals(ProductionType.THIRD_PARTIES, ProductionType.fromCode("T"));
        assertEquals(ProductionType.THIRD_PARTIES, ProductionType.fromCode("t"));
        assertEquals(ProductionType.THIRD_PARTIES, ProductionType.fromCode(" T "));
        assertEquals(ProductionType.THIRD_PARTIES, ProductionType.fromCode(" t "));
    }

    @Test
    @DisplayName("Should throw exception for invalid code")
    void shouldThrowExceptionForInvalidCode() {
        assertThrows(IllegalArgumentException.class, () -> ProductionType.fromCode("Z"));
        assertThrows(IllegalArgumentException.class, () -> ProductionType.fromCode(""));
        assertThrows(IllegalArgumentException.class, () -> ProductionType.fromCode(" "));
        assertThrows(NullPointerException.class, () -> ProductionType.fromCode(null));
    }
}
