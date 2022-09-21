package com.blogapp.dto.categorydto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryResponseDto {

    private Long categoryId;
    private String categoryTitle;
    private String categoryDescription;
}
