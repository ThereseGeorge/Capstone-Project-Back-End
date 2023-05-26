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
import org.springframework.web.bind.annotation.RestController;

import com.ani.project.dto.AppResponse;
import com.ani.project.dto.FacultyDto;
import com.ani.project.service.FacultyService;

import lombok.AllArgsConstructor;

@CrossOrigin
@AllArgsConstructor
@RequestMapping(value = "/faculty")
@RestController
public class FacultyController {
    
    private final FacultyService service;

    @CrossOrigin
    @PostMapping(value="/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<Integer>> createNewFaculty(@Valid @RequestBody FacultyDto dto){
        final Integer sts = service.createNewFaculty(dto);
        final AppResponse<Integer> response = AppResponse.<Integer>builder().sts("success").msg("Faculty Added Successfully").bd(sts).build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<List<FacultyDto>>> allFaculties(){
        List<FacultyDto> faculties = service.all();
        AppResponse<List<FacultyDto>> response = AppResponse.<List<FacultyDto>>builder().sts("success").msg("All Faculties").bd(faculties).build();
        return ResponseEntity.status(200).body(response);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<Integer>> deleteFaculty(@PathVariable Long id){
        final Integer sts = service.deleteFaculty(id);
        final AppResponse<Integer> response = AppResponse.<Integer>builder().sts("success").msg("Faculty deleted successfully").bd(sts).build();
        return ResponseEntity.status(200).body(response);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<FacultyDto>> getFacultyById(@PathVariable Long id){

        final FacultyDto dto = service.fetchFacultyDetails(id);

        final AppResponse<FacultyDto> response = AppResponse.<FacultyDto>builder().sts("success").msg("Faculty details").bd(dto).build();
        return ResponseEntity.ok().body(response);

    }

    @CrossOrigin
    @PutMapping(value="/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<Integer>> updateNewFaculty(@Valid @RequestBody FacultyDto dto){
        final Integer sts = service.updateFaculty(dto);
        final AppResponse<Integer> response = AppResponse.<Integer>builder().sts("success").msg("Faculty Updated Successfully").bd(sts).build();
        return ResponseEntity.ok().body(response);

    }

}
