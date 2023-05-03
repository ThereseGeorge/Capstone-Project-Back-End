package com.ani.project.service;

import com.ani.project.dto.UserDto;

public interface UserService {
    
    Integer createUser(UserDto dto);
    UserDto loginUser(String email, String password);


}
