package com.ani.project.service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ani.project.domain.Student;
import com.ani.project.dto.StudentDto;
import com.ani.project.exception.StudentNotFoundException;
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


    @Override
    public Integer deleteStudent(Long id) {
        // TODO Auto-generated method stub
        repository.deleteById(id);
        return 1;
    }


    @Override
    public StudentDto fetchStudentDetails(Long id) {
        // TODO Auto-generated method stub
        Optional<Student> op = repository.findById(id);
        return mapper.toDto(op.orElseThrow(() -> new StudentNotFoundException("Student" + id + "Not Found")));
    }


    @Override
    public Integer updateStudent(StudentDto dto) {
        // TODO Auto-generated method stub
        Long id= dto.getId();
        Student student= repository.findById(id).orElseThrow(() -> new StudentNotFoundException("Student not found"));
        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
        repository.save(mapper.toDomain(dto));
        return 1;
    }

   
   


    
}


