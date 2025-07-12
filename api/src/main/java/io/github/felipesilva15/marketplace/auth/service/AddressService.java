package io.github.felipesilva15.marketplace.auth.service;

import io.github.felipesilva15.marketplace.auth.model.Address;
import io.github.felipesilva15.marketplace.auth.model.Address;
import io.github.felipesilva15.marketplace.auth.repository.AddressRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AddressService {
    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Transactional(readOnly = true)
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Address findById(Long id) {
        return addressRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Record not found."));
    }

    @Transactional
    public Address create(Address address) {
        return addressRepository.save(address);
    }

    @Transactional
    public Address update(Long id, Address address) {
        Address existingAddress = findById(id);

        address.setId(existingAddress.getId());
        address.setCreatedAt(existingAddress.getCreatedAt());

        return addressRepository.save(address);
    }

    @Transactional
    public void delete(Long id) {
        Address existingAddress = findById(id);
        addressRepository.deleteById(existingAddress.getId());
    }
}
