package com.ani.project.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class UserDto {

    private long id; 

    @NotEmpty(message= "Name cannot be empty")
    @NotNull(message= "Name cannot be null")
    @NotBlank(message= "Name cannot be blank")
    private String name;

    @NotEmpty(message= " Email cannot be empty")
    @NotNull(message= " Email cannot be null")
    @NotBlank(message= " Email cannot be blank")
    @Email
    private String email;

    @NotEmpty(message= "Password cannot be empty")
    @NotNull(message= "Password cannot be null")
    @NotBlank(message= "Password cannot be blank")
    @Size(min=6)
    private String password;

    @NotEmpty(message= "Role cannot be empty")
    @NotNull(message= " Role cannot be null")
    @NotBlank(message= " Role is mandatory")
    private String role;
    
}
