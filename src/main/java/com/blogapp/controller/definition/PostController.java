package com.blogapp.controller.definition;

import com.blogapp.dto.post.PostRequestDto;
import com.blogapp.dto.post.PostResponseDto;
import com.blogapp.payloads.ApiResponse;
import com.blogapp.payloads.PostResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/post")
public interface PostController {

    @PostMapping("/user/{userId}/category/{categoryId}/create")
    public ResponseEntity<PostResponseDto> create(@RequestBody PostRequestDto postRequestDto, @PathVariable Long userId, @PathVariable Long categoryId);

    @PutMapping("/update/{postId}")
    public ResponseEntity<PostResponseDto> update(@RequestBody PostRequestDto postRequestDto,@PathVariable Long postId);

    @DeleteMapping("/deletePost/{postId}")
    public ResponseEntity<ApiResponse> deletePost(@PathVariable Long postId);

    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<List<PostResponseDto>> getPostsByUser(@PathVariable Long userId);

    @GetMapping("/category/{categoryId}/posts")
    public ResponseEntity<List<PostResponseDto>> getPostByCategory(@PathVariable Long categoryId);

    @GetMapping("/getAllPost")
    public ResponseEntity<PostResponse> getAllPost(
            @RequestParam(value = "pageNumber", defaultValue = "0",required = false) Integer pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "5", required = false) Integer pageSize,
            @RequestParam(value = "sortBy", defaultValue = "Id",required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = "asc", required = false) String sortDir
    );

    @GetMapping("/getPostById/{id}")
    public ResponseEntity<PostResponseDto> getPost(@PathVariable Long id);

}
