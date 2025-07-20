package io.github.felipesilva15.marketplace.product.mapper;

import io.github.felipesilva15.marketplace.product.dto.ProductRequest;
import io.github.felipesilva15.marketplace.product.dto.ProductResponse;
import io.github.felipesilva15.marketplace.product.model.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {BrandMapper.class, CategoryMapper.class})
public interface ProductMapper {
    Product toModel(ProductRequest request);
    ProductResponse toResponse(Product model);
    List<ProductResponse> toResponseList(List<Product> modelList);
}
