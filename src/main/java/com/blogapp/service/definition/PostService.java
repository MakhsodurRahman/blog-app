package com.blogapp.service.definition;

import com.blogapp.dto.post.PostRequestDto;
import com.blogapp.dto.post.PostResponseDto;
import com.blogapp.entity.Post;

import java.util.List;

public interface PostService {

    PostResponseDto createPost(PostRequestDto postRequestDto, Long userId, Long categoryId);

    Post UpdatePost(PostRequestDto postRequestDto,Long id);

    void deletePost(Long id);

    Post getPostById(Long id);

    List<Post> getAllPost();

    List<Post> getPostByCategory(Long categoryId);

    List<Post> getPostByUser(Long userId);

    List<Post> searchPost(String keyword);
}
