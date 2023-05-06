package com.ani.project.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ani.project.dto.AppResponse;
import com.ani.project.dto.LoginDto;
import com.ani.project.dto.RegisterDto;

import com.ani.project.service.UserService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {

    private UserService service;

    @PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<Integer>> register(@Valid @RequestBody RegisterDto dto) {
        Integer registerUser = service.registerUser(dto);
        AppResponse<Integer> response = AppResponse.<Integer>builder()
                .sts("success")
                .msg("User registered successfully")
                .bd(registerUser)
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<String>> login(@Valid @RequestBody LoginDto dto) {
        String loginUser = service.loginUser(dto);
        AppResponse<String> response = AppResponse.<String>builder()
                .sts("success")
                .msg("user logged-in successfully")
                .bd(loginUser)
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }
}
