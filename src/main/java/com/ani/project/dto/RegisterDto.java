package com.ani.project.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDto {

    @NotEmpty(message = "Name cannot be empty")
    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name cannot be blank")
    private String name;

    @NotEmpty(message = "Email cannot be empty")
    @NotNull(message = "Email cannot be null")
    @NotNull(message = "Email cannot be blank")
    private String email;

    @NotEmpty(message = "Password cannot be empty")
    @NotNull(message = "Password cannot be null")
    @NotNull(message = "Password cannot be blank")
    private String password;

    @NotEmpty(message = " cannot be empty")
    @NotNull(message = "Name cannot be null")
    @NotNull(message = "Name cannot be blank")
    private String role;

    
}

