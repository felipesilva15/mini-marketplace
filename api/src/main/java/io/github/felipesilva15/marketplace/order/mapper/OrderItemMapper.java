package io.github.felipesilva15.marketplace.order.mapper;

import io.github.felipesilva15.marketplace.order.dto.OrderItemDTO;
import io.github.felipesilva15.marketplace.order.dto.OrderItemRequest;
import io.github.felipesilva15.marketplace.order.dto.OrderItemResponse;
import io.github.felipesilva15.marketplace.order.model.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {
    @Mappings({
            @Mapping(target = "productId", source = "request.product.id"),
            @Mapping(target = "product.id", source = "request.product.id")
    })
    OrderItemDTO toDTO(OrderItemRequest request);

    OrderItemDTO toDTO(OrderItem model);

    List<OrderItemDTO> toDTOList(List<OrderItem> modelList);

    OrderItemResponse toResponse(OrderItemDTO dto);

    List<OrderItemResponse> toResponseList(List<OrderItemDTO> DTOList);
}
