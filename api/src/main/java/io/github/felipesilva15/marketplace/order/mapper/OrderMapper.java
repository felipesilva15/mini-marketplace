package io.github.felipesilva15.marketplace.order.mapper;

import io.github.felipesilva15.marketplace.order.dto.OrderDTO;
import io.github.felipesilva15.marketplace.order.dto.OrderRequest;
import io.github.felipesilva15.marketplace.order.dto.OrderResponse;
import io.github.felipesilva15.marketplace.order.model.Order;
import org.mapstruct.Mapper;
import org.springframework.data.domain.jaxb.SpringDataJaxb;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderDTO toDTO(OrderRequest request);
    OrderDTO toDTO(Order model);
    OrderResponse toResponse(OrderDTO dto);
    List<OrderResponse> toResponseList(List<OrderDTO> DTOList);
    Order toModel(OrderDTO dto);
}
