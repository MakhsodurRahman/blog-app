package com.blogapp.service.implementation;

import com.blogapp.dto.categorydto.CategoryRequestDto;
import com.blogapp.dto.categorydto.CategoryResponseDto;
import com.blogapp.entity.Category;
import com.blogapp.exception.ResourceNotFoundException;
import com.blogapp.repository.CategoryRepository;
import com.blogapp.service.definition.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        Category category = categoryRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("category "," id ",id));

        category.setCategoryTitle(categoryRequestDto.getCategoryTitle());
        category.setCategoryDescription(categoryRequestDto.getCategoryDescription());
        Category saveCategory = categoryRepository.save(category);
        CategoryResponseDto dto = entityToDto(saveCategory);
        return dto;
    }

    @Override
    public void deleteCategory(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("category "," id ",id));
        categoryRepository.delete(category);
    }

    @Override
    public CategoryResponseDto getCategory(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("category "," id ",id));
        CategoryResponseDto responseDto = entityToDto(category);
        return responseDto;
    }

    @Override
    public List<CategoryResponseDto> getAllCategory() {

        List<Category> category = categoryRepository.findAll();
        List<CategoryResponseDto> getAll = category.stream().map(category1 -> entityToDto(category1)).collect(Collectors.toList());
        return getAll;
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
