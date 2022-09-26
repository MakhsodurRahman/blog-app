package com.blogapp.controller.definition;

import com.blogapp.dto.userdto.UserRequestDto;
import com.blogapp.dto.userdto.UserResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/v1")
public interface UserController {


    @PostMapping("/createUser")
    public ResponseEntity<UserResponseDto> createUser(@Valid  @RequestBody UserRequestDto userRequestDto);

    @GetMapping("/getAllUser")
    public List<UserResponseDto> getAllUser();

    @GetMapping("/getUser/{id}")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable Long id);

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<UserResponseDto> updateUser(@Valid @RequestBody UserRequestDto userRequestDto,@PathVariable Long id);

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id);


}
