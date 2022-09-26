package com.blogapp.dto.jwt;

import lombok.Data;
//jwt step : 5
@Data
public class JwtAuthResponse {

    private String token;
    public JwtAuthResponse(String jwt){
        this.token = jwt;
    }
}
