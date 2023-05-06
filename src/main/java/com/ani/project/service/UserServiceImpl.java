package com.ani.project.service;


import java.util.Optional;



import org.springframework.stereotype.Service;
import com.ani.project.domain.User;
import com.ani.project.dto.LoginDto;
import com.ani.project.dto.RegisterDto;
import com.ani.project.repository.UserRepository;
import com.ani.project.util.UserMapper;
import com.ani.project.exception.DuplicateEmailException;

import com.ani.project.exception.UserNotFoundException;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    @Override
    public Integer registerUser(RegisterDto dto) {
        
        User user = mapper.convertor(dto, new User());
        if (repository.existsByEmail(user.getEmail())) {
            throw new DuplicateEmailException("Email already exists. User another mail.");
        }
        repository.save(user);
        return 1;
    }

    @Override
    public String loginUser(LoginDto dto) {
        Optional<User> op = repository.findByEmailAndPassword(dto.getEmail(), dto.getPassword());

        User user = op.orElseThrow(() -> new UserNotFoundException("Email/Password is not valid"));

        return user.getRole();
    }
}
















   