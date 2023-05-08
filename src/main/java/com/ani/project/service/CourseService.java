package com.ani.project.service;

import java.util.List;

import com.ani.project.dto.CourseDto;
import com.ani.project.exception.CourseNotFoundException;

public interface CourseService {
    Integer createNewCourse(CourseDto course);
    List<CourseDto> all();
    Integer deleteCourse(Long id) throws CourseNotFoundException;
    CourseDto fetchCourseDetails(Long id) throws CourseNotFoundException;
    Integer updateCourse(CourseDto course);
    List<CourseDto> getCoursesByCourseName(String courseName) throws CourseNotFoundException;
}
