package com.blogapp.service.definition;

import com.blogapp.dto.UserRequestDto;

import java.util.List;

public interface UserService {
    UserRequestDto createUser(UserRequestDto userRequestDto);
    UserRequestDto updateUser(Long id, UserRequestDto userRequestDto);
    UserRequestDto getUser(Long id);
    List<UserRequestDto> getAllUsers();
    void deleteUser(Long id);

}
