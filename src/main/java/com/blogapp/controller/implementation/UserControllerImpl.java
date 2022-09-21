package com.blogapp.controller.implementation;

import com.blogapp.controller.definition.UserController;
import com.blogapp.dto.UserRequestDto;
import com.blogapp.payloads.ApiResponse;
import com.blogapp.service.definition.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class UserControllerImpl implements UserController {

    private final UserService userService;

    public UserControllerImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ResponseEntity<UserRequestDto> createUser(UserRequestDto userRequestDto) {
        UserRequestDto dto = userService.createUser(userRequestDto);
        return new ResponseEntity<>(dto,HttpStatus.CREATED);
    }


    @Override
    public List<UserRequestDto> getAllUser() {
        return userService.getAllUsers();
    }

    @Override
    public ResponseEntity<UserRequestDto> getUser(Long id) {
        UserRequestDto getUser = userService.getUser(id);
        return ResponseEntity.ok(getUser);
    }

    @Override
    public ResponseEntity<UserRequestDto> updateUser(UserRequestDto userRequestDto, Long id) {
        UserRequestDto requestDto = userService.updateUser(id,userRequestDto);
        return ResponseEntity.ok(requestDto);
    }

    @Override
    public ResponseEntity<?> deleteUser(Long id) {
        this.userService.deleteUser(id);
        //return new ResponseEntity<>(Map.of("message","user deleted"),HttpStatus.OK);
        return new ResponseEntity(new ApiResponse("user deleted",true),HttpStatus.OK);
    }
}
