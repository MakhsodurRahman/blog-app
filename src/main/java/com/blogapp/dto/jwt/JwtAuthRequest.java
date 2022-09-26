package com.blogapp.dto.jwt;

import lombok.Data;

@Data
public class JwtAuthRequest {

    private String userName;
    private String password;
}
