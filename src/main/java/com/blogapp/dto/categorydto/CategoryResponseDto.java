package com.blogapp.dto.categorydto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class CategoryResponseDto {

    private Long categoryId;
    private String categoryTitle;
    private String categoryDescription;
}
