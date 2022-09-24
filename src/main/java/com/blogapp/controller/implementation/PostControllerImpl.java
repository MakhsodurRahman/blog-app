package com.blogapp.controller.implementation;

import com.blogapp.controller.definition.PostController;

import com.blogapp.dto.post.PostRequestDto;
import com.blogapp.dto.post.PostResponseDto;
import com.blogapp.payloads.ApiResponse;
import com.blogapp.payloads.PostResponse;
import com.blogapp.service.definition.FileService;
import com.blogapp.service.definition.PostService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class PostControllerImpl implements PostController {

    private final PostService postService;
    private final FileService fileService;

    @Value("${project.image}")
    private String path;

    public PostControllerImpl(PostService postService, FileService fileService) {
        this.postService = postService;
        this.fileService = fileService;
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
    public ResponseEntity<PostRequestDto> getPost(Long id) {
        PostRequestDto post = postService.getPostById(id);
        return new ResponseEntity<>(post,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<PostResponseDto>> search(String keyword) {
        List<PostResponseDto> responseDto = postService.searchPost(keyword);
        return new ResponseEntity<>(responseDto,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PostResponseDto> fileUpload(MultipartFile image, Long postId) throws IOException {

        String fileName = null;
        PostRequestDto response = postService.getPostById(postId);
        fileName = fileService.uploadImage(image, path);
        response.setImageName(fileName);
        PostResponseDto dto = postService.updatePost(response, postId);

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

}
