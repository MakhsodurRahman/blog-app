package com.blogapp.dto.userdto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserResponseDto {

    private Long id;
    private String name;
    private String email;
    @JsonIgnore
    private String password;
    private String about;
}
