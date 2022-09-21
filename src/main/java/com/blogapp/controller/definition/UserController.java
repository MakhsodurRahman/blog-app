package com.blogapp.controller.definition;

import com.blogapp.dto.UserRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1")
public interface UserController {


    @PostMapping("/createUser")
    public ResponseEntity<UserRequestDto> createUser(@RequestBody UserRequestDto userRequestDto);

    @GetMapping("/getAllUser")
    public List<UserRequestDto> getAllUser();

    @GetMapping("/getUser/{id}")
    public ResponseEntity<UserRequestDto> getUser(@PathVariable Long id);

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<UserRequestDto> updateUser(@RequestBody UserRequestDto userRequestDto,@PathVariable Long id);

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id);


}