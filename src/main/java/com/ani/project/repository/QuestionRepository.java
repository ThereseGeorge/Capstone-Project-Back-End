package com.ani.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ani.project.domain.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
}

