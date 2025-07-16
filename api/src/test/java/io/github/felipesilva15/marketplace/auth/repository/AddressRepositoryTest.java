package io.github.felipesilva15.marketplace.auth.repository;

import io.github.felipesilva15.marketplace.auth.model.Address;
import io.github.felipesilva15.marketplace.auth.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class AddressRepositoryTest {
    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private TestEntityManager entityManager;

    private User user;

    @BeforeEach
    void setUp() {
        user = new User(
                null,
                "User test",
                "user@test.com",
                "123456",
                "89831395875",
                Collections.emptyList()
        );
        entityManager.persistAndFlush(user);
    }

    @Test
    @DisplayName("Should save and retrieve address")
    void shouldSaveAndRetrieveAddress() {
        Address newAddress = new Address(
                null,
                "Address test",
                "04869951",
                "Rua dos canários",
                "Vila dos canários",
                "São Canário",
                "São Canárinho",
                "SC",
                "1234",
                null,
                user
        );

        Address savedAddress = addressRepository.save(newAddress);

        assertNotNull(savedAddress.getId());

        Optional<Address> retrievedAddress = addressRepository.findById(savedAddress.getId());

        assertTrue(retrievedAddress.isPresent());
        assertEquals(savedAddress.getId(), retrievedAddress.get().getId());
        assertEquals("Rua dos canários", retrievedAddress.get().getStreet());
        assertEquals(user.getId(), retrievedAddress.get().getUser().getId());
    }

    @Test
    @DisplayName("Should delete address")
    void shouldDeleteAddress() {
        Address addressToDelete = new Address(
                null,
                "Address test",
                "04869951",
                "Rua dos canários",
                "Vila dos canários",
                "São Canário",
                "São Canárinho",
                "SC",
                "1234",
                null,
                user
        );
        entityManager.persistAndFlush(addressToDelete);
        Long addressId = addressToDelete.getId();

        addressRepository.deleteById(addressId);

        Optional<Address> foundAddress = addressRepository.findById(addressId);
        assertFalse(foundAddress.isPresent());
    }
}
