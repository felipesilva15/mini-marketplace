package io.github.felipesilva15.marketplace.product.mapper;

import io.github.felipesilva15.marketplace.product.dto.CategoryRequest;
import io.github.felipesilva15.marketplace.product.dto.CategoryResponse;
import io.github.felipesilva15.marketplace.product.model.Category;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category toModel(CategoryRequest request);
    CategoryResponse toResponse(Category model);
    List<CategoryResponse> toResponseList(List<Category> modelList);
}
