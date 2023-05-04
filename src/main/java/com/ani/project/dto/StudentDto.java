package com.ani.project.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class StudentDto {
    
    
    private Long id;

    @NotEmpty(message="Name cannot be null")
    @NotNull(message="Name cannot be null")
    @NotBlank(message="Name cannot be null")
    private String name;

    @NotEmpty(message="Email cannot be null")
    @NotNull(message="Email cannot be null")
    @NotBlank(message="Email cannot be null")
    private String email;
}