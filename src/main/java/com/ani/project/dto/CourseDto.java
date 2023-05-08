package com.ani.project.dto;

import java.time.LocalDate;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.URL;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class CourseDto {
    
    private Long id;

    @NotEmpty(message="Course name cannot be null")
    @NotNull(message="Course name cannot be null")
    @NotBlank(message="Course name cannot be null")
    private String courseName;

    @NotEmpty(message="Faculty name cannot be null")
    @NotNull(message="Faculty name cannot be null")
    @NotBlank(message="Faculty name cannot be null")
    private String facultyName;

   
    @NotNull(message="Start Date cannot be null")
    private LocalDate startDate;

    
    @NotNull(message="End date cannot be null")
    private LocalDate endDate;

    @Pattern(regexp = "^https?://\\S+$", message = "Invalid material link format")
    @URL(message="Invalid URL")
    private String material;

    @Pattern(regexp = "^https?://\\S+$", message = "Invalid material link format")
    @URL(message="Invalid URL")
    private String recording;

    @AssertTrue(message = "End date must be after start date")
    private boolean isEndDateAfterStartDate() {
         if (startDate == null || endDate == null) {
             return true; // null values will be handled by @NotNull annotation
        }
         return endDate.isAfter(startDate) || endDate.isEqual(startDate);
     }
}
