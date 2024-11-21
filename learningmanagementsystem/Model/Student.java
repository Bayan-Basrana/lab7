package com.example.learningmanagementsystem.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Student {
    @NotEmpty(message ="ID cannot be empty" )
    @Size(min=10 ,max=10, message ="ID Must be exactly 10")
    private String nationalID;
    @NotEmpty(message= "name is empty")
    @Size(min=4, message="name must be more than 3")
    @Pattern(regexp="^[a-zA-Z]+$", message=  "Name must contain only characters")
    private String name;
    @NotEmpty(message= "phone is empty")
    @Pattern(regexp= "^05\\d{8}$", message = "must be start with 05 and contain 10 numbers")
    private String phone;
    @NotEmpty(message="Email cannot be empty")
    @Email(message ="invalid email")
    private String email;
    @NotEmpty (message= "Education is empty")
    private String education;
    @NotNull(message = "GPA cannot be empty")
    @Positive(message = "GPA must be positive number")
    private double GPA;
    @NotEmpty (message= "status is empty")
    @Pattern(regexp = "graduate|undergraduate")
    private String status;
}
