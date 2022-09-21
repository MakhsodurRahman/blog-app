package com.blogapp.dto.userdto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
@Setter
public class UserRequestDto {

    private Long id;

    @NotEmpty
    @Size(min = 3, max = 10,message = "min 3 character & max 10 character")
    private String name;

    @Email(message = "Email in not valid")
    private String email;

    @NotEmpty
    @Size(min = 3,max = 5,message = "min 3 and max 5 character")
    private String password;

    @NotEmpty
    private String about;
}
