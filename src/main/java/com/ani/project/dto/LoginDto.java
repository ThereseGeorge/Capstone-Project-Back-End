package com.ani.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {
    
    @NotEmpty(message = "Email cannot be empty")
    @NotNull(message = "Email cannot be null")
    @NotBlank(message = "Email cannot be blank")
    @Email(message="Email is invalid")
    private String email;

    
    @NotNull(message = "Password cannot be null")
    @NotBlank(message = "Password is mandatory")
    private String password;

    
}
