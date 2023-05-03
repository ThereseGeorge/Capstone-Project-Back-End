package com.ani.project.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ani.project.domain.User;
import com.ani.project.dto.UserDto;
import com.ani.project.exception.InvalidInputException;
import com.ani.project.repository.UserRepository;
import com.ani.project.util.UserMapper;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository repository;
    private final UserMapper mapper;
  

    @Override
    public UserDto loginUser(String email, String password) {
        Optional<User> user=repository.findByEmailAndPassword(email, password);
        return mapper.toDto(user.orElseThrow(()-> new UserNotFoundException("User not found")) );
        
    }
    @Override
    public Integer createUser(UserDto dto) {
        // TODO Auto-generated method stub
        repository.save(mapper.toDomain(dto));
        return 1;
    }

  
}