package com.blogapp.controller.implementation;

import com.blogapp.controller.definition.PostController;
import com.blogapp.dto.post.PostRequestDto;
import com.blogapp.dto.post.PostResponseDto;
import com.blogapp.entity.Post;
import com.blogapp.payloads.ApiResponse;
import com.blogapp.payloads.PostResponse;
import com.blogapp.service.definition.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @Override
    public ResponseEntity<PostResponseDto> update(PostRequestDto postRequestDto,Long postId) {
        PostResponseDto post = postService.updatePost(postRequestDto,postId);

        return new ResponseEntity<>(post,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ApiResponse> deletePost(Long postId) {

        postService.deletePost(postId);
        return new ResponseEntity(new ApiResponse("post deleted",true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<PostResponseDto>> getPostsByUser(Long userId) {

        List<PostResponseDto> responseDto = postService.getPostByUser(userId);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<PostResponseDto>> getPostByCategory(Long categoryId) {

        List<PostResponseDto> posts = postService.getPostByCategory(categoryId);
        return new ResponseEntity<>(posts,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PostResponse> getAllPost(Integer pageNumber, Integer pageSize,String sortBy,String sortDir) {

        PostResponse posts = postService.getAllPost(pageNumber,pageSize,sortBy,sortDir);
        return new ResponseEntity<>(posts,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PostResponseDto> getPost(Long id) {
        PostResponseDto post = postService.getPostById(id);
        return new ResponseEntity<>(post,HttpStatus.OK);
    }
}
