package com.example.learningmanagementsystem.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Course {
    @NotEmpty(message= "course code cannot be empty")
@Size(min=5, max=7 ,message="course code must be between 5 and 7")
    private String courseCode;
    @NotEmpty(message= "course name cannot be empty")
 @Size(min=3, message="name must be more than 3 characters")
    private String courseName;
    @NotNull(message = "Credit hours cannot be null")
    @Min(value = 1,message = "Credit hours must be at least 1")
    @Max(value = 6,message = "Credit hours must not exceed 6")
    private int creditHours;
    @NotNull(message = "Schedule start date cannot be empty")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate scheduleStart;
    @NotNull(message = "Schedule end date cannot be empty")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate scheduleEnd;
    @NotEmpty(message= "status cannot be empty")
@Pattern(regexp = "ongoing|completed|upcoming")
    private String status;
}
