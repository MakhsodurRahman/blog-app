package com.blogapp.dto.comments;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommentsResponseDto {

    private Long id;
    private String content;
}
