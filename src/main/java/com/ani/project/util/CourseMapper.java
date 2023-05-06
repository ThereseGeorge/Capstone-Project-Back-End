package com.ani.project.util;

import org.springframework.stereotype.Component;

import com.ani.project.domain.Course;
import com.ani.project.dto.CourseDto;





@Component
public class CourseMapper {
    public Course toDomain(CourseDto dto){
        return Course.builder().courseName(dto.getCourseName()).facultyName(dto.getFacultyName()).startDate(dto.getStartDate()).endDate(dto.getEndDate()).material(dto.getMaterial()).recording(dto.getRecording()).build();

    }

    public CourseDto toDto(Course domain){
        return new CourseDto(domain.getId(), domain.getCourseName(), domain.getFacultyName(), domain.getStartDate(), domain.getEndDate(), domain.getMaterial(), domain.getRecording());
    }
}
