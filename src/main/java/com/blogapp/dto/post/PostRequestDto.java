package com.blogapp.dto.post;

import com.blogapp.entity.Category;
import com.blogapp.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class PostRequestDto {


    private String postTitle;
    private String content;
    private String imageName;
    private Date addDate;
    private Category category;
    private User user;

}
