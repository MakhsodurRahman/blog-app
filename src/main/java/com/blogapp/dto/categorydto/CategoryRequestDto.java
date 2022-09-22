package com.blogapp.dto.categorydto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Getter
@Setter
@NoArgsConstructor
public class CategoryRequestDto {
    @NotEmpty
    @Size(min = 3,message = "min size must be 3 character")
    private String categoryTitle;
    @NotEmpty
    @Size(min = 5,message = "min size must be 5 character")
    private String categoryDescription;
}
