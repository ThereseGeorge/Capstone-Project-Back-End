package com.ani.project.service;


import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import com.ani.project.domain.User;
import com.ani.project.dto.LoginDto;
import com.ani.project.dto.RegisterDto;
import com.ani.project.dto.UserDto;
import com.ani.project.repository.UserRepository;
import com.ani.project.exception.UserNotFoundException;

import lombok.AllArgsConstructor;

@Transactional
@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public UserDto register(RegisterDto registerDto) {
        User user = new User();
        user.setName(registerDto.getName());
        user.setEmail(registerDto.getEmail());
        user.setPassword(registerDto.getPassword());
        user.setRole(registerDto.getRole());
        userRepository.save(user);
        return convertToDto(user);
    }

    @Override
    public UserDto login(LoginDto loginDto) throws UserNotFoundException{
        User user = userRepository.findByEmailAndPassword(loginDto.getEmail(), loginDto.getPassword());
        if (user == null) {
            throw new UserNotFoundException("Invalid email or password");
        }
        return convertToDto(user);

    }

    private UserDto convertToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setRole(user.getRole());
        return userDto;
    }
}
