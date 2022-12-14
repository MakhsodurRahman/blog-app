package com.blogapp.controller.definition;

import com.blogapp.dto.jwt.JwtAuthRequest;
import com.blogapp.dto.jwt.JwtAuthResponse;
import com.blogapp.dto.userdto.UserRequestDto;
import com.blogapp.dto.userdto.UserResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequestMapping("/api/v1/auth")
public interface AuthController {

    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponse> createToken(
            @RequestBody JwtAuthRequest request
            ) throws Exception;
    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> register(@ModelAttribute UserRequestDto userRequestDto, MultipartFile image) throws IOException;
}
