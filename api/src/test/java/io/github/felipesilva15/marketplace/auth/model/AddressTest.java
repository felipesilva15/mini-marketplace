package io.github.felipesilva15.marketplace.auth.model;

import io.github.felipesilva15.marketplace.common.model.BaseModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AddressTest {
    private Address address;

    @BeforeEach
    void setUp() {
        address = new Address(
                1L,
                "Address test",
                "04869951",
                "Rua dos canários",
                "Vila dos canários",
                "São Canário",
                "São Canárinho",
                "SC",
                "1234",
                null,
                new User()
        );
    }

    @Test
    @DisplayName("Should extends from BaseModel")
    void shouldExtendsFromBaseModel() {
        assertInstanceOf(BaseModel.class, address);
    }

    @Test
    @DisplayName("Should create address with correct data")
    void shouldCreateAddressWithCorrectData() {
        assertNotNull(address);
        assertEquals(1L, address.getId());
        assertEquals("Address test", address.getName());
        assertEquals("04869951", address.getPostalCode());
        assertEquals("Rua dos canários", address.getStreet());
        assertEquals("Vila dos canários", address.getLocality());
        assertEquals("São Canário", address.getCity());
        assertEquals("São Canárinho", address.getRegion());
        assertEquals("SC", address.getRegionCode());
        assertEquals("1234", address.getNumber());
        assertNull(address.getComplement());
        assertNotNull(address.getUser());
        assertInstanceOf(User.class, address.getUser());
    }

    @Test
    @DisplayName("Should allow properties update")
    void shouldAllowPropertiesUpdate() {
        address.setName("new name");
        address.setNumber("new number");
        address.setComplement("new complement");

        assertEquals("new name", address.getName());
        assertEquals("new number", address.getNumber());
        assertEquals("new complement", address.getComplement());
    }

    @Test
    @DisplayName("Should return true for equal objects")
    void shouldReturnTrueForEqualObjects() {
        Address secondAddress = new Address(
                1L,
                "Address test",
                "04869951",
                "Rua dos canários",
                "Vila dos canários",
                "São Canário",
                "São Canárinho",
                "SC",
                "1234",
                null,
                new User()
        );

        assertEquals(address, secondAddress);
        assertEquals(address, address);
    }

    @Test
    @DisplayName("Should return false for different objects")
    void shouldReturnFalseForDifferentObjects() {
        Address secondAddress = new Address(
                1L,
                "Address test",
                "04869951",
                "Rua das araras",
                "Vila das araras",
                "Araras",
                "Ararinhas",
                "AR",
                "4321",
                null,
                new User()
        );

        assertNotEquals(null, address);
        assertNotEquals(new Object(), address);
        assertNotEquals(secondAddress, address);
    }

    @Test
    @DisplayName("Hash codes should be equal for equal objects")
    void hashCodesShouldBeEqualForEqualObjects() {
        Address secondAddress = new Address(
                1L,
                "Address test",
                "04869951",
                "Rua dos canários",
                "Vila dos canários",
                "São Canário",
                "São Canárinho",
                "SC",
                "1234",
                null,
                new User()
        );

        assertEquals(address.hashCode(), secondAddress.hashCode());
    }

    @Test
    @DisplayName("Should create address with no args constructor")
    void shouldCreateAddressWithNoArgsConstructor() {
        Address testAddress = new Address();

        assertNotNull(testAddress);
        assertNull(testAddress.getId());
        assertNull(testAddress.getName());
    }
}
