package io.github.felipesilva15.marketplace.product.repository;

import io.github.felipesilva15.marketplace.product.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
