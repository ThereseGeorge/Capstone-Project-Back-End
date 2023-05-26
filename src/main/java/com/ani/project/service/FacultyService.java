package com.ani.project.service;

import java.util.List;

import com.ani.project.dto.FacultyDto;
import com.ani.project.exception.FacultyNotFoundException;

public interface FacultyService {
    Integer createNewFaculty(FacultyDto faculty);
    List<FacultyDto> all();
    Integer deleteFaculty(Long id) throws FacultyNotFoundException;
    FacultyDto fetchFacultyDetails(Long id) throws FacultyNotFoundException;
    Integer updateFaculty(FacultyDto faculty);
}
