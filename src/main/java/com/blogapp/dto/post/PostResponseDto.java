package com.blogapp.dto.post;

import com.blogapp.dto.categorydto.CategoryResponseDto;
import com.blogapp.dto.userdto.UserResponseDto;
import com.blogapp.entity.Category;
import com.blogapp.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class PostResponseDto {

    private Long id;
    private String postTitle;
    private String content;
    private String imageName;
    private Date addDate;
    private UserResponseDto user;
    private CategoryResponseDto category;
}
