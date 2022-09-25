package com.blogapp.controller.implementation;

import com.blogapp.controller.definition.CommentsController;
import com.blogapp.dto.comments.CommentRequestDto;
import com.blogapp.dto.comments.CommentsResponseDto;
import com.blogapp.payloads.ApiResponse;
import com.blogapp.service.definition.CommentsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentsControllerImpl implements CommentsController {
    private final CommentsService commentsService;

    public CommentsControllerImpl(CommentsService commentsService) {
        this.commentsService = commentsService;
    }

    @Override
    public ResponseEntity<CommentsResponseDto> createComment(CommentRequestDto commentRequestDto, Long postId) {
        CommentsResponseDto responseDto = commentsService.createComment(commentRequestDto,postId);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ApiResponse> deleteComment(Long commentId) {
        commentsService.delete(commentId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("comment deleted",true),HttpStatus.OK);
    }
}
