package com.blogapp.controller.definition;

import com.blogapp.config.AppConstants;
import com.blogapp.dto.FileResponse;
import com.blogapp.dto.post.PostRequestDto;
import com.blogapp.dto.post.PostResponseDto;
import com.blogapp.payloads.ApiResponse;
import com.blogapp.payloads.PostResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
            @RequestParam(value = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER,required = false) Integer pageNumber,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.SORT_BY,required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.SORT_DIR, required = false) String sortDir
    );

    @GetMapping("/getPostById/{id}")
    public ResponseEntity<PostRequestDto> getPost(@PathVariable Long id);

    @GetMapping("/search/{keyword}")
    public ResponseEntity<List<PostResponseDto>> search(@PathVariable String keyword);

    @PostMapping("/image/upload/{postId}")
    public ResponseEntity<PostResponseDto> fileUpload(
            @RequestParam("image") MultipartFile image,
            @PathVariable Long postId) throws IOException;
}
