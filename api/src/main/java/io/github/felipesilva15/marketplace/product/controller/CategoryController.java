package io.github.felipesilva15.marketplace.product.controller;

import io.github.felipesilva15.marketplace.product.dto.CategoryRequest;
import io.github.felipesilva15.marketplace.product.dto.CategoryResponse;
import io.github.felipesilva15.marketplace.product.mapper.CategoryMapper;
import io.github.felipesilva15.marketplace.product.model.Category;
import io.github.felipesilva15.marketplace.product.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    public CategoryController(CategoryService categoryService, CategoryMapper categoryMapper) {
        this.categoryService = categoryService;
        this.categoryMapper = categoryMapper;
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> findAll(){
        List<Category> categories = categoryService.findAll();
        List<CategoryResponse> response = categoryMapper.toResponseList(categories);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> findById(@PathVariable Long id){
        Category category = categoryService.findById(id);
        CategoryResponse response = categoryMapper.toResponse(category);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> save(@Valid @RequestBody CategoryRequest request){
        Category category = categoryService.create(categoryMapper.toModel(request));
        CategoryResponse response = categoryMapper.toResponse(category);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponse> update(@PathVariable Long id, @Valid @RequestBody CategoryRequest request){
        Category category = categoryService.update(id, categoryMapper.toModel(request));
        CategoryResponse response = categoryMapper.toResponse(category);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CategoryResponse> delete(@PathVariable Long id){
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
