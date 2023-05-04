package com.ani.project.util;

import com.ani.project.domain.Student;
import com.ani.project.dto.StudentDto;

import lombok.AllArgsConstructor;
import lombok.ToString;

@Component
public class StudentMapper {
    public Student toDomain(StudentDto dto){
        return Student.builder().id(dto.getId()).name(dto.getName()).email(dto.getEmail()).build();

    }

    public StudentDto toDto(Student domain){
        return new StudentDto(domain.getId(), domain.getName(), domain.getEmail());
    }
}
