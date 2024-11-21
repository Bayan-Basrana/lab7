package com.example.learningmanagementsystem.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Registration {
@NotEmpty(message= "registration ID cannot be empty")
@Size(min=8 ,max= 10, message= "registration ID must be between 8 and 10")
    private  String registration_ID;
    @NotEmpty(message= "student ID cannot be empty")
    @Size(min=10 ,max=10, message ="ID Must be exactly 10")
    private String studentID;
    @NotEmpty(message= "course code cannot be empty")
    @Size(min=5, max=7 ,message="course code must be between 5 and 7")
    private String courseCode;
    @NotNull(message = "semester cannot be empty")
    @Min(value = 1,message = "Semester must be at least 1")
    private int semester;
    @NotEmpty(message= "status cannot be empty")
@Pattern(regexp = "enrolled|completed|withdrawn")
    private String status;
    @Positive(message = "max seat must be positive")
private int maxSeat;

}
