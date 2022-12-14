package com.blogapp.service.definition;

import com.blogapp.dto.post.PostRequestDto;
import com.blogapp.dto.post.PostResponseDto;
import com.blogapp.entity.Post;
import com.blogapp.payloads.PostResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface PostService {

    PostResponseDto createPost(PostRequestDto postRequestDto, Long userId, Long categoryId, MultipartFile image) throws IOException;

    PostResponseDto updatePost(PostRequestDto postRequestDto,Long id);

    void deletePost(Long id);

    PostResponseDto getPostById(Long id);

    PostResponse getAllPost(Integer pageNumber, Integer pageSize,String sortBy,String sortDir);

    List<PostResponseDto> getPostByCategory(Long categoryId);

    List<PostResponseDto> getPostByUser(Long userId);

    List<PostResponseDto> searchPost(String keyword);
}
