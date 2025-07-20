package io.github.felipesilva15.marketplace.product.service;

import io.github.felipesilva15.marketplace.product.model.Product;
import io.github.felipesilva15.marketplace.product.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Product findById(Long id) {
        return productRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Record not found."));
    }

    @Transactional
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Transactional
    public Product update(Long id, Product product) {
        Product existingProduct = findById(id);

        product.setId(existingProduct.getId());
        product.setCreatedAt(existingProduct.getCreatedAt());

        return productRepository.save(product);
    }

    @Transactional
    public void delete(Long id) {
        Product existingProduct = findById(id);
        productRepository.deleteById(existingProduct.getId());
    }
}
