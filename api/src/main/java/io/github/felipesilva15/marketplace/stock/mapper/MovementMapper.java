package io.github.felipesilva15.marketplace.stock.mapper;

import io.github.felipesilva15.marketplace.stock.dto.MovementRequest;
import io.github.felipesilva15.marketplace.stock.dto.MovementResponse;
import io.github.felipesilva15.marketplace.stock.model.Movement;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovementMapper {
    @Mapping(target = "productId", source = "request.product.id")
    Movement toModel(MovementRequest request);
    MovementResponse toResponse(Movement model);
    List<MovementResponse> toResponseList(List<Movement> modelList);
}
