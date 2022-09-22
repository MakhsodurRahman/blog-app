package com.blogapp.controller.definition;

import com.blogapp.dto.post.PostRequestDto;
import com.blogapp.dto.post.PostResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/post")
public interface PostController {

    @PostMapping("/user/{userId}/category/{categoryId}/create")
    public ResponseEntity<PostResponseDto> create(@RequestBody PostRequestDto postRequestDto, @PathVariable Long userId, @PathVariable Long categoryId);

    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<List<PostResponseDto>> getPostsByUser(@PathVariable Long userId);

    @GetMapping("/category/{categoryId}/posts")
    public ResponseEntity<List<PostResponseDto>> getPostByCategory(@PathVariable Long categoryId);

    @GetMapping("/getAllPost")
    public ResponseEntity<List<PostResponseDto>> getAllPost();
}
