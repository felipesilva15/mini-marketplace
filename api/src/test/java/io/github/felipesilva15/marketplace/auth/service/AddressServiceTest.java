package io.github.felipesilva15.marketplace.auth.service;

import io.github.felipesilva15.marketplace.auth.model.Address;
import io.github.felipesilva15.marketplace.auth.model.User;
import io.github.felipesilva15.marketplace.auth.repository.AddressRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AddressServiceTest {
    @Mock
    private AddressRepository addressRepository;

    @InjectMocks
    private AddressService addressService;

    private Address addressOne;
    private Address addressTwo;
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

        addressOne = new Address(
                1L,
                "Test one",
                "04869951",
                "Test street one",
                "Test locality one",
                "Test city one",
                "Test region one",
                "T1",
                "1234",
                null,
                user
        );
        addressTwo = new Address(
                2L,
                "Test two",
                "04869952",
                "Test street two",
                "Test locality two",
                "Test city two",
                "Test region two",
                "T2",
                "4321",
                "Test complement two",
                user
        );
    }

    @Test
    @DisplayName("Should retrieve all addresses")
    void shouldFindAllAddresses() {
        when(addressRepository.findAll()).thenReturn(Arrays.asList(addressOne, addressTwo));

        List<Address> addresses = addressService.findAll();

        assertNotNull(addresses);
        assertEquals(2, addresses.size());
        assertTrue(addresses.contains(addressOne));
        assertTrue(addresses.contains(addressTwo));
        verify(addressRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("Should find address by ID when exists")
    void shouldFindAddressByIdWhenExists() throws EntityNotFoundException {
        when(addressRepository.findById(1L)).thenReturn(Optional.of(addressOne));

        Address foundAddress = addressService.findById(1L);

        assertNotNull(foundAddress);
        assertEquals(addressOne.getId(), foundAddress.getId());
        assertEquals(addressOne.getName(), foundAddress.getName());
        verify(addressRepository, times(1)).findById(1L);
    }

    @Test
    @DisplayName("Should throw EntityNotFoundException when address does not exist by ID")
    void shouldThrowEntityNotFoundExceptionWhenAddressDoesNotExistById() {
        when(addressRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> addressService.findById(99L));
        verify(addressRepository, times(1)).findById(99L);
    }

    @Test
    @DisplayName("Should create a new address")
    void shouldCreateNewAddress() {
        Address newAddress = new Address(
                null,
                "New address",
                "04869953",
                "New street",
                "New locality",
                "New city",
                "New region",
                "T1",
                "1234",
                null,
                user
        );
        when(addressRepository.save(any(Address.class))).thenAnswer(invocation -> {
            Address addressToSave = invocation.getArgument(0);
            addressToSave.setId(3L);
            return addressToSave;
        });

        Address createdAddress = addressService.create(newAddress);

        assertNotNull(createdAddress);
        assertNotNull(createdAddress.getId());
        assertEquals("New address", createdAddress.getName());
        verify(addressRepository, times(1)).save(newAddress);
    }

    @Test
    @DisplayName("Should update existing address")
    void shouldUpdateExistingAddress() throws EntityNotFoundException {
        Address existingAddress = new Address(
                1L,
                "Original address",
                "04869953",
                "Original street",
                "Original locality",
                "Original city",
                "Original region",
                "T1",
                "1234",
                null,
                user
        );
        Address updatedAddressData = new Address(
                null,
                "Updated address",
                "04869953",
                "Updated street",
                "Updated locality",
                "Updated city",
                "Updated region",
                "T1",
                "1234",
                null,
                user
        );

        when(addressRepository.findById(1L)).thenReturn(Optional.of(existingAddress));
        when(addressRepository.save(any(Address.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Address resultAddress = addressService.update(1L, updatedAddressData);

        assertNotNull(resultAddress);
        assertEquals(1L, resultAddress.getId());
        assertEquals("Updated address", resultAddress.getName());
        assertEquals("04869953", resultAddress.getPostalCode());
        verify(addressRepository, times(1)).findById(1L);
        verify(addressRepository, times(1)).save(updatedAddressData);
    }

    @Test
    @DisplayName("Should throw EntityNotFoundException when updating non existent address ID")
    void shouldThrowEntityNotFoundExceptionWhenUpdatingNonExistentAddress() {
        when(addressRepository.findById(99L)).thenReturn(Optional.empty());

        Address updatedAddressData = new Address(
                null,
                "Updated address",
                "04869953",
                "Updated street",
                "Updated locality",
                "Updated city",
                "Updated region",
                "T1",
                "1234",
                null,
                user
        );
        assertThrows(EntityNotFoundException.class, () -> addressService.update(99L, updatedAddressData));
        verify(addressRepository, times(1)).findById(99L);
        verify(addressRepository, never()).save(any(Address.class));
    }

    @Test
    @DisplayName("Should delete address")
    void shouldDeleteAddressSuccessfully() throws EntityNotFoundException {
        when(addressRepository.findById(1L)).thenReturn(Optional.of(addressOne));

        addressService.delete(1L);

        verify(addressRepository, times(1)).findById(1L);
        verify(addressRepository, times(1)).deleteById(1L);
    }

    @Test
    @DisplayName("Should throw EntityNotFoundException when deleting non existent address ID")
    void shouldThrowEntityNotFoundExceptionWhenDeletingNonExistentAddress() {
        when(addressRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> addressService.delete(99L));
        verify(addressRepository, times(1)).findById(99L);
        verify(addressRepository, never()).deleteById(anyLong());
    }
}
