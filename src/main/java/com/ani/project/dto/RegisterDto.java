package com.ani.project.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDto {

    @NotEmpty(message = "Name cannot be empty")
    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name cannot be blank")
    private String name;

    @NotEmpty(message = "Email cannot be empty")
    @NotNull(message = "Email cannot be null")
    @NotBlank(message = "Email cannot be blank")
    @Email(message="Invalid email")
    private String email;

    @NotEmpty(message = "Password cannot be empty")
    @NotNull(message = "Password cannot be null")
    @NotBlank(message = "Password cannot be blank")
    @Size(min=6, message="Password should be atleast of length 6")
    private String password;

   
    @NotNull(message = "Role cannot be null")
    @NotBlank(message = "Role is mandatory")
    private String role;

    
}

