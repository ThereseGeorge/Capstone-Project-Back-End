package com.ani.project.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ani.project.domain.Faculty;
import com.ani.project.dto.FacultyDto;
import com.ani.project.exception.FacultyNotFoundException;
import com.ani.project.repository.FacultyRepository;
import com.ani.project.util.FacultyMapper;

import lombok.AllArgsConstructor;

@Transactional
@AllArgsConstructor
@Service
public class FacultyServiceImpl implements FacultyService {
    
    public final FacultyRepository repository;
    public final FacultyMapper mapper;


    @Override
    public Integer createNewFaculty(FacultyDto dto) {
        // TODO Auto-generated method stub
        repository.save(mapper.toDomain(dto));
        return 1;
    }


    @Override
    public List<FacultyDto> all() {
        // TODO Auto-generated method stub
        return repository.findAll().stream().map(mapper :: toDto).collect(Collectors.toList());
    }


    @Override
    public Integer deleteFaculty(Long id) {
        // TODO Auto-generated method stub
        repository.deleteById(id);
        return 1;
    }


    @Override
    public FacultyDto fetchFacultyDetails(Long id) {
        // TODO Auto-generated method stub
        Optional<Faculty> op = repository.findById(id);
        return mapper.toDto(op.orElseThrow(() -> new FacultyNotFoundException("Faculty" + id + "Not Found")));
    }


    @Override
    public Integer updateFaculty(FacultyDto dto) {
        // TODO Auto-generated method stub
        Long id= dto.getId();
        Faculty faculty= repository.findById(id).orElseThrow(() -> new FacultyNotFoundException("Faculty not found"));
        faculty.setName(dto.getName());
        faculty.setEmail(dto.getEmail());
        repository.save(faculty);

    
        return 1;
    }
}
