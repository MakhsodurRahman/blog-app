package com.blogapp.controller.implementation;

import com.blogapp.controller.definition.PostController;
import com.blogapp.dto.post.PostRequestDto;
import com.blogapp.dto.post.PostResponseDto;
import com.blogapp.service.definition.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostControllerImpl implements PostController {
    private final PostService postService;

    public PostControllerImpl(PostService postService) {
        this.postService = postService;
    }

    @Override
    public ResponseEntity<PostResponseDto> create(PostRequestDto postRequestDto, Long userId, Long categoryId) {
        PostResponseDto responsePost = postService.createPost(postRequestDto,userId,categoryId);
        return new ResponseEntity<>(responsePost, HttpStatus.CREATED);
    }
}
