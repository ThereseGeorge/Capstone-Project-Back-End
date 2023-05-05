package com.ani.project.service;

import java.util.List;



import com.ani.project.dto.StudentDto;
import com.ani.project.exception.StudentNotFoundException;

public interface StudentService {

    Integer createNewStudent(StudentDto student);
    List<StudentDto> all();
    Integer deleteStudent(Long id) throws StudentNotFoundException;
    StudentDto fetchStudentDetails(Long id) throws StudentNotFoundException;
    Integer updateStudent(StudentDto dto);
}
