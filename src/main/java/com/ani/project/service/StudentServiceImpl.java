package com.ani.project.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ani.project.dto.StudentDto;
import com.ani.project.repository.StudentRepository;
import com.ani.project.util.StudentMapper;

import lombok.AllArgsConstructor;

@Transactional
@AllArgsConstructor
@Service
public class StudentServiceImpl implements StudentService{

    public final StudentRepository repository;
    public final StudentMapper mapper;


    @Override
    public Integer createNewStudent(StudentDto dto) {
        // TODO Auto-generated method stub
        repository.save(mapper.toDomain(dto));
        return 1;
    }


    @Override
    public List<StudentDto> all() {
        // TODO Auto-generated method stub
        return repository.findAll().stream().map(mapper :: toDto).collect(Collectors.toList());
    }
    
}

