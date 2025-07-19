package io.github.felipesilva15.marketplace.product.service;

import io.github.felipesilva15.marketplace.product.model.Category;
import io.github.felipesilva15.marketplace.product.repository.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Transactional(readOnly = true)
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Category findById(Long id) {
        return categoryRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Record not found."));
    }

    @Transactional
    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    @Transactional
    public Category update(Long id, Category category) {
        Category existingCategory = findById(id);

        category.setId(existingCategory.getId());
        category.setCreatedAt(existingCategory.getCreatedAt());

        return categoryRepository.save(category);
    }

    @Transactional
    public void delete(Long id) {
        Category existingCategory = findById(id);
        categoryRepository.deleteById(existingCategory.getId());
    }
}
