package io.github.felipesilva15.marketplace.stock.mapper;

import io.github.felipesilva15.marketplace.stock.dto.DepositRequest;
import io.github.felipesilva15.marketplace.stock.dto.DepositResponse;
import io.github.felipesilva15.marketplace.stock.model.Deposit;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DepositMapper {
    Deposit toModel(DepositRequest request);
    DepositResponse toResponse(Deposit model);
    List<DepositResponse> toResponseList(List<Deposit> modelList);
}
