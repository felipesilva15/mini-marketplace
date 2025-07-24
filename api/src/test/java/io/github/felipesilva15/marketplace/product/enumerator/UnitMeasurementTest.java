package io.github.felipesilva15.marketplace.product.enumerator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UnitMeasurementTest {
    @Test
    @DisplayName("Should have correct codes")
    void shouldHaveCorrectCodes() {
        assertEquals("PC", UnitMeasurement.PART.getCode());
        assertEquals("PT", UnitMeasurement.PACKAGE.getCode());
        assertEquals("UN", UnitMeasurement.UNIT.getCode());
        assertEquals("KG", UnitMeasurement.KILOGRAM.getCode());
        assertEquals("GR", UnitMeasurement.GRAM.getCode());
        assertEquals("LT", UnitMeasurement.LITER.getCode());
        assertEquals("ML", UnitMeasurement.MILLILITER.getCode());
        assertEquals("MT", UnitMeasurement.METER.getCode());
        assertEquals("MM", UnitMeasurement.MILLIMETER.getCode());
        assertEquals("CM", UnitMeasurement.CENTIMETER.getCode());
    }

    @Test
    @DisplayName("Should return correct unit measurement valid code")
    void shouldReturnCorrectUnitMeasurementFromValidCode() {
        assertEquals(UnitMeasurement.UNIT, UnitMeasurement.fromCode("UN"));
        assertEquals(UnitMeasurement.UNIT, UnitMeasurement.fromCode("un"));
        assertEquals(UnitMeasurement.UNIT, UnitMeasurement.fromCode(" UN "));
        assertEquals(UnitMeasurement.UNIT, UnitMeasurement.fromCode(" un "));

        assertEquals(UnitMeasurement.KILOGRAM, UnitMeasurement.fromCode("KG"));
        assertEquals(UnitMeasurement.KILOGRAM, UnitMeasurement.fromCode("kg"));
        assertEquals(UnitMeasurement.KILOGRAM, UnitMeasurement.fromCode(" KG "));
        assertEquals(UnitMeasurement.KILOGRAM, UnitMeasurement.fromCode(" kg "));
    }

    @Test
    @DisplayName("Should throw exception for invalid code")
    void shouldThrowExceptionForInvalidCode() {
        assertThrows(IllegalArgumentException.class, () -> UnitMeasurement.fromCode("ZZ"));
        assertThrows(IllegalArgumentException.class, () -> UnitMeasurement.fromCode(""));
        assertThrows(IllegalArgumentException.class, () -> UnitMeasurement.fromCode(" "));
        assertThrows(NullPointerException.class, () -> UnitMeasurement.fromCode(null));
    }
}
