package com.ani.project.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ani.project.domain.Course;
import com.ani.project.dto.CourseDto;
import com.ani.project.exception.CourseNotFoundException;
import com.ani.project.repository.CourseRepository;
import com.ani.project.util.CourseMapper;

import lombok.AllArgsConstructor;

@Transactional
@AllArgsConstructor
@Service
public class CourseServiceImpl implements CourseService{

    public final CourseRepository repository;
    public final CourseMapper mapper;


    @Override
    public Integer createNewCourse(CourseDto dto) {
        // TODO Auto-generated method stub
        repository.save(mapper.toDomain(dto));
        return 1;
    }


    @Override
    public List<CourseDto> all() {
        // TODO Auto-generated method stub
        return repository.findAll().stream().map(mapper :: toDto).collect(Collectors.toList());
    }


    @Override
    public Integer deleteCourse(Long id) {
        // TODO Auto-generated method stub
        repository.deleteById(id);
        return 1;
    }


    @Override
    public CourseDto fetchCourseDetails(Long id) {
        // TODO Auto-generated method stub
        Optional<Course> op = repository.findById(id);
        return mapper.toDto(op.orElseThrow(() -> new CourseNotFoundException("Course" + id + "Not Found")));
    }


    @Override
    public Integer updateCourse(CourseDto dto) {
        // TODO Auto-generated method stub
        repository.save(mapper.toDomain(dto));
        return 1;
    }
    
}



