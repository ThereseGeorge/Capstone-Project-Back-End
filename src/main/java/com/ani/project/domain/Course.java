package com.ani.project.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.URL;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;

    @Column(name="course_name", nullable = false)
    private String courseName;

    @Column(name="faculty_name", nullable = false)
    private String facultyName;

    @Column(name="start_date")
    private LocalDate startDate;

    @Column(name="end_Date"  )
    private LocalDate endDate;

    @Column(name="material" )
    @URL(message="Invalid URL")
    private String material;

    @Column(name="recording" )
    @URL(message="Invalid URL")
    private String recording;
    
}
