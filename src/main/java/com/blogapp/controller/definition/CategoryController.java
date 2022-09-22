package com.blogapp.controller.definition;

import com.blogapp.dto.categorydto.CategoryRequestDto;
import com.blogapp.dto.categorydto.CategoryResponseDto;
import com.blogapp.entity.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/v1")
public interface CategoryController {

    @PostMapping("/create")
    public ResponseEntity<CategoryResponseDto> create(@Valid @RequestBody CategoryRequestDto categoryRequestDto);

    @PutMapping("/update/{id}")
    public ResponseEntity<CategoryResponseDto> update(@Valid @RequestBody CategoryRequestDto categoryRequestDto,@PathVariable Long id);

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id);

    @GetMapping("/getCategory/{id}")
    public ResponseEntity<CategoryResponseDto> getCategory(@PathVariable Long id);

    @GetMapping("/getAllCategory")
    public List<CategoryResponseDto> getAllCategory();
}
