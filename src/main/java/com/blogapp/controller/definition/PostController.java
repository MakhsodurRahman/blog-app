package com.blogapp.controller.definition;

import com.blogapp.dto.post.PostRequestDto;
import com.blogapp.dto.post.PostResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/v1/post")
public interface PostController {

    @RequestMapping("/user/{userId}/category/{categoryId}/create")
    public ResponseEntity<PostResponseDto> create(@RequestBody PostRequestDto postRequestDto, @PathVariable Long userId, @PathVariable Long categoryId);
}
