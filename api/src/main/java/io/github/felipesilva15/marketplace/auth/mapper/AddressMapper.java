package io.github.felipesilva15.marketplace.auth.mapper;

import io.github.felipesilva15.marketplace.auth.dto.AddressRequest;
import io.github.felipesilva15.marketplace.auth.dto.AddressResponse;
import io.github.felipesilva15.marketplace.auth.model.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface AddressMapper {
    Address toModel(AddressRequest request);
    @Mapping(target = "user_id", expression = "java(model.getUser().getId())")
    AddressResponse toResponse(Address model);
    List<AddressResponse> toResponseList(List<Address> modelList);
}
