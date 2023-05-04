package com.ani.project.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import lombok.AllArgsConstructor;

@CrossOrigin
@AllArgsConstructor
@RequestMapping(value = "/student")
@RestController
public class StudentController {
    private final StudentService service;

    @CrossOrigin
    @PostMapping(value="/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<Integer>> createNewStudent(@RequestBody StudentDto dto){
        final Integer sts = service.createNewStudent(dto);
        final AppResponse<Integer> response = AppResponse.<Integer>builder().sts("success").msg("Student Added Successfully").bd(sts).build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<List<StudentDto>>> allStudents(){
        List<StudentDto> students = service.all();
        AppResponse<List<StudentDto>> response = AppResponse.<List<StudentDto>>builder().sts("success").msg("All Students").bd(students).build();
        return ResponseEntity.status(200).body(response);
    }
    
    
}

