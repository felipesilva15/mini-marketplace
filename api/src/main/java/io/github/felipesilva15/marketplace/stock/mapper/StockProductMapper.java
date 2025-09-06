package io.github.felipesilva15.marketplace.stock.mapper;

import io.github.felipesilva15.marketplace.product.model.Product;
import io.github.felipesilva15.marketplace.stock.dto.ProductDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StockProductMapper {
    ProductDTO toDto(Product dto);
    List<ProductDTO> toDtoList(List<Product> modelList);
}
