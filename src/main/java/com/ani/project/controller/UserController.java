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

import com.ani.project.dto.LoginDto;
import com.ani.project.dto.RegisterDto;
import com.ani.project.dto.UserDto;
import com.ani.project.service.UserService;


import lombok.AllArgsConstructor;



@AllArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @PostMapping(value="/register", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE) 
    public ResponseEntity<UserDto> register(@Valid @RequestBody RegisterDto registerDto) {
        UserDto userDto = userService.register(registerDto);
        return new ResponseEntity<>(userDto, HttpStatus.CREATED);
    }

    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> login(@Valid @RequestBody LoginDto loginDto) {
        UserDto userDto = userService.login(loginDto);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }
}






