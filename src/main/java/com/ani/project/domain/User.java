package com.ani.project.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;

    @NotBlank
    @Column(name="name", unique = true, nullable = false)
    private String name;

    @NotBlank
    @Email
    @Column(name="email", unique=true, nullable = false)
    private String email;

    @NotBlank
    @Size(min=6)
    @Column(name="password", unique=true, nullable = false)
    private String password;

    @NotBlank
    @Column(name="role", nullable = false)
    private String role;
    
}


