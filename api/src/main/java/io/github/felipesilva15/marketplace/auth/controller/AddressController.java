package io.github.felipesilva15.marketplace.auth.controller;

import io.github.felipesilva15.marketplace.auth.dto.AddressRequest;
import io.github.felipesilva15.marketplace.auth.dto.AddressResponse;
import io.github.felipesilva15.marketplace.auth.mapper.AddressMapper;
import io.github.felipesilva15.marketplace.auth.model.Address;
import io.github.felipesilva15.marketplace.auth.service.AddressService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {
    private final AddressService addressService;
    private final AddressMapper addressMapper;

    public AddressController(AddressService addressService, AddressMapper addressMapper) {
        this.addressService = addressService;
        this.addressMapper = addressMapper;
    }

    @GetMapping
    public ResponseEntity<List<AddressResponse>> getAll() {
        List<Address> addressList = this.addressService.findAll();
        List<AddressResponse> response = this.addressMapper.toResponseList(addressList);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressResponse> getById(@PathVariable Long id){
        Address address = addressService.findById(id);
        AddressResponse response = addressMapper.toResponse(address);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity<AddressResponse> save(@Valid @RequestBody AddressRequest request){
        Address address = addressService.create(addressMapper.toModel(request));
        AddressResponse response = addressMapper.toResponse(address);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddressResponse> update(@PathVariable Long id, @Valid @RequestBody AddressRequest request){
        Address address = addressService.update(id, addressMapper.toModel(request));
        AddressResponse response = addressMapper.toResponse(address);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AddressResponse> delete(@PathVariable Long id){
        addressService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
