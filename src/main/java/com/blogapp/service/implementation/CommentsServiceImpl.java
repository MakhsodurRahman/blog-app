package com.blogapp.service.implementation;

import com.blogapp.dto.comments.CommentRequestDto;
import com.blogapp.dto.comments.CommentsResponseDto;
import com.blogapp.entity.Comments;
import com.blogapp.entity.Post;
import com.blogapp.exception.ResourceNotFoundException;
import com.blogapp.repository.CommentsRepository;
import com.blogapp.repository.PostRepository;
import com.blogapp.service.definition.CommentsService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CommentsServiceImpl implements CommentsService {

    private final CommentsRepository commentsRepository;
    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    public CommentsServiceImpl(CommentsRepository commentsRepository, PostRepository postRepository, ModelMapper modelMapper) {
        this.commentsRepository = commentsRepository;
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CommentsResponseDto createComment(CommentRequestDto commentRequestDto, Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(()->new ResourceNotFoundException("post id "," id",postId));
        Comments comments = modelMapper.map(commentRequestDto,Comments.class);
        comments.setPost(post);
        Comments res = commentsRepository.save(comments);
        return modelMapper.map(res,CommentsResponseDto.class);
    }

    @Override
    public void delete(Long commentId) {
        Comments comments = commentsRepository.findById(commentId).orElseThrow(()->new ResourceNotFoundException("comment id"," id ",commentId));
        commentsRepository.delete(comments);

    }
}
