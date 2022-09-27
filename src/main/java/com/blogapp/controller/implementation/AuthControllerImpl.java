package com.blogapp.controller.implementation;

import com.blogapp.controller.definition.AuthController;
import com.blogapp.dto.jwt.JwtAuthRequest;
import com.blogapp.dto.jwt.JwtAuthResponse;
import com.blogapp.dto.userdto.UserRequestDto;
import com.blogapp.dto.userdto.UserResponseDto;
import com.blogapp.exception.ApiException;
import com.blogapp.security.JwtTokenHelper;
import com.blogapp.service.definition.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

//jwt step : 7
@RestController
public class AuthControllerImpl implements AuthController {

    private final JwtTokenHelper jwtTokenHelper;
    private final UserDetailsService userDetailsService;
    private final AuthenticationManager authenticationManager;
    private final UserService userService;

    public AuthControllerImpl(JwtTokenHelper jwtTokenHelper, UserDetailsService userDetailsService, AuthenticationManager authenticationManager, UserService userService) {
        this.jwtTokenHelper = jwtTokenHelper;
        this.userDetailsService = userDetailsService;
        this.authenticationManager = authenticationManager;
        this.userService = userService;
    }

    @Override
    public ResponseEntity<JwtAuthResponse> createToken(JwtAuthRequest request) throws Exception {

        try{
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUserName(),request.getPassword())
        );
        } catch (BadCredentialsException e) {
        System.out.println("Invalid Detials !!");
        throw new ApiException("Invalid username or password !!");
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUserName());
        final String jwt = jwtTokenHelper.generateToken(userDetails);

        return ResponseEntity.ok(new JwtAuthResponse(jwt));

    }

    @Override
    public ResponseEntity<UserResponseDto> register(UserRequestDto userRequestDto, MultipartFile image) throws IOException {
        UserResponseDto user = userService.registerUser(userRequestDto,image);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

}
