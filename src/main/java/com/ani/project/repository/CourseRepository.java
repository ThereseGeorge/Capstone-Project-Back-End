package com.ani.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ani.project.domain.Course;

public interface CourseRepository extends JpaRepository<Course,Long>{
    
    
    List<Course> findAllByCourseName(String courseName);

    
}
