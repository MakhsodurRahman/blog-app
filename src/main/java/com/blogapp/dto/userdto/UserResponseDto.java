package com.blogapp.dto.userdto;

import com.blogapp.dto.role.RoleResponseDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

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

    private Set<RoleResponseDto> roles = new HashSet<>();
}
