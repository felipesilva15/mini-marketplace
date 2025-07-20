package io.github.felipesilva15.marketplace.product.repository;

import io.github.felipesilva15.marketplace.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
