package com.ani.project.service;

import com.ani.project.exception.UserNotFoundException;
import com.ani.project.dto.LoginDto;
import com.ani.project.dto.RegisterDto;
import com.ani.project.dto.UserDto;


public interface UserService {

    UserDto register(RegisterDto registerDto);
    UserDto login(LoginDto loginDto) throws UserNotFoundException;

}

