package com.blogapp.service.definition;

import com.blogapp.dto.post.PostRequestDto;
import com.blogapp.dto.post.PostResponseDto;
import com.blogapp.entity.Post;
import com.blogapp.payloads.PostResponse;

import java.util.List;

public interface PostService {

    PostResponseDto createPost(PostRequestDto postRequestDto, Long userId, Long categoryId);

    PostResponseDto updatePost(PostRequestDto postRequestDto,Long id);

    void deletePost(Long id);

    PostRequestDto getPostById(Long id);

    PostResponse getAllPost(Integer pageNumber, Integer pageSize,String sortBy,String sortDir);

    List<PostResponseDto> getPostByCategory(Long categoryId);

    List<PostResponseDto> getPostByUser(Long userId);

    List<PostResponseDto> searchPost(String keyword);
}
