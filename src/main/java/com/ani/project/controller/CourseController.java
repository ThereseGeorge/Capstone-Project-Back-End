package com.ani.project.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ani.project.dto.AppResponse;
import com.ani.project.dto.CourseDto;
import com.ani.project.service.CourseService;

import lombok.AllArgsConstructor;

@CrossOrigin
@AllArgsConstructor
@RequestMapping(value = "/course")
@RestController
public class CourseController {
    private final CourseService service;

    @CrossOrigin
    @PostMapping(value="/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<Integer>> createNewCourse(@Valid @RequestBody CourseDto dto){
        final Integer sts = service.createNewCourse(dto);
        final AppResponse<Integer> response = AppResponse.<Integer>builder().sts("success").msg("Course Added Successfully").bd(sts).build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<List<CourseDto>>> allCourses(){
        List<CourseDto> courses = service.all();
        AppResponse<List<CourseDto>> response = AppResponse.<List<CourseDto>>builder().sts("success").msg("All Courses").bd(courses).build();
        return ResponseEntity.status(200).body(response);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<Integer>> deleteCourse(@PathVariable Long id){
        final Integer sts = service.deleteCourse(id);
        final AppResponse<Integer> response = AppResponse.<Integer>builder().sts("success").msg("Course deleted successfully").bd(sts).build();
        return ResponseEntity.status(200).body(response);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<CourseDto>> getCourseById(@PathVariable Long id){

        final CourseDto dto = service.fetchCourseDetails(id);

        final AppResponse<CourseDto> response = AppResponse.<CourseDto>builder().sts("success").msg("Course details").bd(dto).build();
        return ResponseEntity.ok().body(response);

    }

    @CrossOrigin
    @PutMapping(value="/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<Integer>> updateNewCourse(@Valid @RequestBody CourseDto dto){
        final Integer sts = service.updateCourse(dto);
        final AppResponse<Integer> response = AppResponse.<Integer>builder().sts("success").msg("Course Updated Successfully").bd(sts).build();
        return ResponseEntity.ok().body(response);

    }

    @GetMapping(value = "/name", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<List<CourseDto>>> getCoursesByCourseName(@RequestParam String courseName) {
        List<CourseDto> courses = service.getCoursesByCourseName(courseName);
        AppResponse<List<CourseDto>> response = AppResponse.<List<CourseDto>>builder().sts("success").msg("All Courses").bd(courses).build();
        return ResponseEntity.status(200).body(response);
    }

    
    
}

