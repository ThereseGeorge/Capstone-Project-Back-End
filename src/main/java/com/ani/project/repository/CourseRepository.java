package com.ani.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ani.project.domain.Course;

public interface CourseRepository extends JpaRepository<Course,Long>{
    
}
