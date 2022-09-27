package com.blogapp.service.definition;

import com.blogapp.dto.userdto.UserRequestDto;
import com.blogapp.dto.userdto.UserResponseDto;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface UserService {

    UserResponseDto  registerUser(@ModelAttribute UserRequestDto userRequestDto, MultipartFile image) throws IOException;
    UserResponseDto createUser(UserRequestDto userRequestDto);
    UserResponseDto updateUser(Long id, UserRequestDto userRequestDto);
    UserResponseDto getUser(Long id);
    List<UserResponseDto> getAllUsers();
    void deleteUser(Long id);

}
