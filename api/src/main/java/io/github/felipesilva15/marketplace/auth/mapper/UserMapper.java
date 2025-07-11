package io.github.felipesilva15.marketplace.auth.mapper;

import io.github.felipesilva15.marketplace.auth.dto.UserResponse;
import org.mapstruct.Mapper;

import io.github.felipesilva15.marketplace.auth.dto.UserRequest;
import io.github.felipesilva15.marketplace.auth.model.User;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toModel(UserRequest request);
    UserResponse toResponse(User model);
    List<UserResponse> toResponseList(List<User> modelList);
}
