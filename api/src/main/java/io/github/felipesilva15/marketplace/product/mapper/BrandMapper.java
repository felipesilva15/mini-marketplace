package io.github.felipesilva15.marketplace.product.mapper;

import io.github.felipesilva15.marketplace.product.dto.BrandRequest;
import io.github.felipesilva15.marketplace.product.dto.BrandResponse;
import io.github.felipesilva15.marketplace.product.model.Brand;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BrandMapper {
    Brand toModel(BrandRequest request);
    BrandResponse toResponse(Brand model);
    List<BrandResponse> toResponseList(List<Brand> modelList);
}
