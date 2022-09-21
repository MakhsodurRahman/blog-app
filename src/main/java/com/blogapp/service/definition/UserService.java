package com.blogapp.service.definition;

import com.blogapp.dto.userdto.UserRequestDto;
import com.blogapp.dto.userdto.UserResponseDto;

import java.util.List;

public interface UserService {
    UserResponseDto createUser(UserRequestDto userRequestDto);
    UserResponseDto updateUser(Long id, UserRequestDto userRequestDto);
    UserResponseDto getUser(Long id);
    List<UserResponseDto> getAllUsers();
    void deleteUser(Long id);

}
