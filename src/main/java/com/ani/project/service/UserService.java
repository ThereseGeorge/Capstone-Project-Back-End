package com.ani.project.service;


import com.ani.project.dto.LoginDto;
import com.ani.project.dto.RegisterDto;


public interface UserService {

    Integer registerUser(RegisterDto dto);

    String loginUser(LoginDto dto);


}

