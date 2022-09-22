package com.blogapp.service.implementation;

import com.blogapp.dto.post.PostRequestDto;
import com.blogapp.entity.Post;
import com.blogapp.service.definition.PostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Override
    public Post createPost(PostRequestDto postRequestDto) {
        return null;
    }

    @Override
    public Post UpdatePost(PostRequestDto postRequestDto, Long id) {
        return null;
    }

    @Override
    public void deletePost(Long id) {

    }

    @Override
    public Post getPostById(Long id) {
        return null;
    }

    @Override
    public List<Post> getAllPost() {
        return null;
    }

    @Override
    public List<Post> getPostByCategory(Long categoryId) {
        return null;
    }

    @Override
    public List<Post> getPostByUser(Long userId) {
        return null;
    }

    @Override
    public List<Post> searchPost(String keyword) {
        return null;
    }
}
