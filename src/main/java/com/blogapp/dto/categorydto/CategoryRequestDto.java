package com.blogapp.dto.categorydto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryRequestDto {

    private String categoryTitle;
    private String categoryDescription;
}
