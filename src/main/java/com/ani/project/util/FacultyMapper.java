package com.ani.project.util;

import org.springframework.stereotype.Component;

import com.ani.project.domain.Faculty;
import com.ani.project.dto.FacultyDto;

@Component
public class FacultyMapper {
    
    public Faculty toDomain(FacultyDto dto){
        return Faculty.builder().name(dto.getName()).email(dto.getEmail()).build();

    }

    public FacultyDto toDto(Faculty domain){
        return new FacultyDto(domain.getId(), domain.getName(), domain.getEmail());
    }
}


