package io.github.felipesilva15.marketplace.stock.provider;

import io.github.felipesilva15.marketplace.stock.dto.ProductDTO;

import java.util.List;

public interface ProductProvider {
    ProductDTO getProductById(Long id);
    List<ProductDTO> getProductsByIds(List<Long> ids);
}
