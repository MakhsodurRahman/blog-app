package com.blogapp.controller.definition;

import com.blogapp.dto.comments.CommentRequestDto;
import com.blogapp.dto.comments.CommentsResponseDto;
import com.blogapp.payloads.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/comments")
public interface CommentsController {

    @PostMapping("/post/{postId}/comment")
    public ResponseEntity<CommentsResponseDto> createComment(@RequestBody CommentRequestDto commentRequestDto, @PathVariable Long postId);

    @DeleteMapping("/deleteComment/{commentId}")
    public ResponseEntity<ApiResponse> deleteComment(@PathVariable Long commentId);
}
