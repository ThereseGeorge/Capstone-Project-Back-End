package com.ani.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ani.project.domain.Student;

public interface StudentRepository extends JpaRepository<Student,Long>{
    
}
