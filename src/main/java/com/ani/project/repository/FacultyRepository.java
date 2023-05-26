package com.ani.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ani.project.domain.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty,Long>{
    
}
