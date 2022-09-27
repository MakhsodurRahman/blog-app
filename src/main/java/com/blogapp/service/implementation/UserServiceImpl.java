package com.blogapp.service.implementation;

import com.blogapp.config.AppConstants;
import com.blogapp.dto.userdto.UserRequestDto;
import com.blogapp.dto.userdto.UserResponseDto;
import com.blogapp.entity.Role;
import com.blogapp.entity.User;
import com.blogapp.exception.ResourceNotFoundException;
import com.blogapp.repository.RoleRepository;
import com.blogapp.repository.UserRepository;
import com.blogapp.service.definition.FileService;
import com.blogapp.service.definition.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final FileService fileService;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder, RoleRepository roleRepository, FileService fileService) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
        this.fileService = fileService;
    }

    @Value("${project.image}")
    private String path;

    @Override
    public UserResponseDto registerUser(UserRequestDto userRequestDto, MultipartFile image) throws IOException {

        String fileName = fileService.uploadImage(image,path);
        User user = modelMapper.map(userRequestDto,User.class);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setImageName(fileName);

        Role role = roleRepository.findById(Long.valueOf(AppConstants.NORMAL_USER)).get();
        user.getRoles().add(role);

        User saveUser = userRepository.save(user);
        return modelMapper.map(user,UserResponseDto.class);
    }

    @Override
    public UserResponseDto createUser(UserRequestDto userRequestDto) {

        User user = dtoToEntity(userRequestDto);
        User saveUser = userRepository.save(user);
        return entityToDto(saveUser);

    }

    @Override
    public UserResponseDto updateUser(Long id, UserRequestDto userRequestDto) {
        User user = userRepository.findById(id).orElseThrow(()->  new ResourceNotFoundException("user "," id ",id));

        user.setName(userRequestDto.getName());
        user.setEmail(userRequestDto.getEmail());
        user.setPassword(userRequestDto.getPassword());
        user.setAbout(userRequestDto.getAbout());
        User updateUser = userRepository.save(user);
        UserResponseDto dto = entityToDto(updateUser);
        return dto;
    }

    @Override
    public UserResponseDto getUser(Long id) {
        User user = userRepository.findById(id).orElseThrow((()->  new ResourceNotFoundException("user "," id ",id)));

        UserResponseDto findUser = entityToDto(user);
        return findUser;
    }

    @Override
    public List<UserResponseDto> getAllUsers() {

        List<User> users = userRepository.findAll();
        List<UserResponseDto> dto = users.stream().map(user -> entityToDto(user)).collect(Collectors.toList());
        return dto;
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow((()->  new ResourceNotFoundException("user "," id ",id)));
        userRepository.delete(user);
    }

    //this is called model mapper
    private User dtoToEntity(UserRequestDto userRequestDto){
        User user = modelMapper.map(userRequestDto, User.class);
//        user.setId(userRequestDto.getId());
//        user.setName(userRequestDto.getName());
//        user.setEmail(userRequestDto.getEmail());
//        user.setAbout(userRequestDto.getAbout());
//        user.setPassword((userRequestDto.getPassword()));
        return user;
    }

    private UserResponseDto entityToDto(User user){
        UserResponseDto userResponseDto = modelMapper.map(user,UserResponseDto.class);
//        UserRequestDto userRequestDto = new UserRequestDto();
//        userRequestDto.setId(user.getId());
//        userRequestDto.setName(user.getName());
//        userRequestDto.setEmail(user.getEmail());
//        userRequestDto.setPassword(user.getPassword());
//        userRequestDto.setAbout(user.getAbout());
        return userResponseDto;
    }
}
