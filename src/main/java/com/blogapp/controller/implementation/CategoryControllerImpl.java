package com.blogapp.controller.implementation;

import com.blogapp.controller.definition.CategoryController;
import com.blogapp.dto.categorydto.CategoryRequestDto;
import com.blogapp.dto.categorydto.CategoryResponseDto;
import com.blogapp.entity.Category;
import com.blogapp.payloads.ApiResponse;
import com.blogapp.service.definition.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryControllerImpl implements CategoryController {

    private final CategoryService categoryService;

    public CategoryControllerImpl(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public ResponseEntity<CategoryResponseDto> create(CategoryRequestDto categoryRequestDto) {
        CategoryResponseDto categoryResponseDto = categoryService.createCategory(categoryRequestDto);
        return new  ResponseEntity<CategoryResponseDto>(categoryResponseDto,HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<CategoryResponseDto> update(CategoryRequestDto categoryRequestDto, Long id) {
        CategoryResponseDto categoryResponseDto = categoryService.updateCategory(id,categoryRequestDto);
        return ResponseEntity.ok(categoryResponseDto);
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        this.categoryService.deleteCategory(id);
        return new ResponseEntity<ApiResponse>(new ApiResponse("category deleted",true),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CategoryResponseDto> getCategory(Long id) {
        CategoryResponseDto responseDto = categoryService.getCategory(id);
        return  ResponseEntity.ok(responseDto);
    }

    @Override
    public List<CategoryResponseDto> getAllCategory() {
        return categoryService.getAllCategory();

    }

}
