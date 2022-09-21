package com.blogapp.service.implementation;

import com.blogapp.dto.categorydto.CategoryRequestDto;
import com.blogapp.dto.categorydto.CategoryResponseDto;
import com.blogapp.entity.Category;
import com.blogapp.repository.CategoryRepository;
import com.blogapp.service.definition.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CategoryResponseDto createCategory(CategoryRequestDto categoryRequestDto) {
        Category category = dtoToEntity(categoryRequestDto);
        Category saveCategory = categoryRepository.save(category);
        return entityToDto(saveCategory);
    }

    @Override
    public CategoryResponseDto updateCategory(Long id, CategoryRequestDto categoryRequestDto) {
        return null;
    }

    @Override
    public void deleteCategory(Long id) {

    }

    @Override
    public CategoryResponseDto getCategory(Long id) {
        return null;
    }

    @Override
    public List<CategoryResponseDto> getAllCategory() {
        return null;
    }

    private Category dtoToEntity(CategoryRequestDto categoryRequestDto){
        Category category = modelMapper.map(categoryRequestDto,Category.class);
        return category;
    }

    private CategoryResponseDto entityToDto(Category category){
        CategoryResponseDto responseDto = modelMapper.map(category,CategoryResponseDto.class);
        return responseDto;
    }
}
