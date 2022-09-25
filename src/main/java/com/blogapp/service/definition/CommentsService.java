package com.blogapp.service.definition;

import com.blogapp.dto.comments.CommentRequestDto;
import com.blogapp.dto.comments.CommentsResponseDto;

public interface CommentsService {

    CommentsResponseDto createComment(CommentRequestDto commentRequestDto,Long postId);
    void delete(Long commentId);
}
