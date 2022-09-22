package com.blogapp.service.definition;

import com.blogapp.dto.categorydto.CategoryRequestDto;
import com.blogapp.dto.categorydto.CategoryResponseDto;
import com.blogapp.entity.Category;

import java.util.List;

public interface CategoryService {

    CategoryResponseDto createCategory(CategoryRequestDto categoryRequestDto);
    CategoryResponseDto updateCategory(Long id,CategoryRequestDto categoryRequestDto);
    void deleteCategory(Long id);
    CategoryResponseDto getCategory(Long id);
    List<CategoryResponseDto> getAllCategory();
}
