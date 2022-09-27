package com.blogapp;

import com.blogapp.config.AppConstants;
import com.blogapp.entity.Role;
import com.blogapp.repository.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootApplication
public class BlogAppApplication implements CommandLineRunner {

    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    public BlogAppApplication(RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public static void main(String[] args) {
        SpringApplication.run(BlogAppApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(passwordEncoder.encode("hri"));

        try {
                Role roleUser = new Role();
                roleUser.setId(AppConstants.NORMAL_USER);
                roleUser.setRoleName("ROLE_USER");

                Role roleAdmin = new Role();
                roleAdmin.setId(AppConstants.ADMIN_USER);
                roleAdmin.setRoleName("ROLE_ADMIN");
                List<Role> roleList = List.of(roleUser, roleAdmin);
                List<Role> result = roleRepository.saveAll(roleList);

                for (Role role : result) {
                    System.out.println(role.getRoleName());
                }
            }catch (Exception e){
                e.printStackTrace();
        }
    }
}
