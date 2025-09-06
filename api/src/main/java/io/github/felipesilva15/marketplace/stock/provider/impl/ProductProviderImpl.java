package io.github.felipesilva15.marketplace.stock.provider.impl;

import io.github.felipesilva15.marketplace.product.model.Product;
import io.github.felipesilva15.marketplace.product.repository.ProductRepository;
import io.github.felipesilva15.marketplace.stock.dto.ProductDTO;
import io.github.felipesilva15.marketplace.stock.mapper.StockProductMapper;
import io.github.felipesilva15.marketplace.stock.provider.ProductProvider;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductProviderImpl implements ProductProvider {
    private final ProductRepository productRepository;
    private final StockProductMapper stockProductMapper;

    public ProductProviderImpl(ProductRepository productRepository, StockProductMapper stockProductMapper) {
        this.productRepository = productRepository;
        this.stockProductMapper = stockProductMapper;
    };

    @Override
    public ProductDTO getProductById(Long id) {
        Optional<Product> product = productRepository
                .findById(id);

        return product.map(stockProductMapper::toDto).orElse(null);

    }

    @Override
    public List<ProductDTO> getProductsByIds(List<Long> ids) {
        List<Product> products = productRepository.findAllById(ids);

        return stockProductMapper.toDtoList(products);
    }
}
