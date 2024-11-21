package com.example.learningmanagementsystem.Controller;

import com.example.learningmanagementsystem.ApiREsponse.ApiResponse;
import com.example.learningmanagementsystem.Model.Course;
import com.example.learningmanagementsystem.Srevice.CourseService;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/course")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;


    @GetMapping("/getCourse")
    public ResponseEntity getCourse (){
        ArrayList<Course> courses= courseService.getCourses();
        return ResponseEntity.status(200).body(courses);
    }

    @PostMapping("/addCourse")
    public ResponseEntity addCourse (@RequestBody @Valid Course course, Errors errors){
if(errors.hasErrors()){
    return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
}
courseService.addCourse(course);
return ResponseEntity.status(200).body(new ApiResponse("course added successfully"));
    }

@PutMapping("/updateCourse/{courseCode}")
    public ResponseEntity updateCourse (@PathVariable String courseCode, @RequestBody @Valid Course course ,Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        boolean isUpdate =courseService.updateCourse(courseCode,course) ;
        if (isUpdate){
            return ResponseEntity.status(200).body(new ApiResponse(" course updated successfully"));
        }
        else return ResponseEntity.status(400).body("course Code not found");
    }

    @DeleteMapping("/deleteCourse/{courseCode}")
    public ResponseEntity deleteCourse (@PathVariable String courseCode){
        boolean isDeleted = courseService.deleteCourse(courseCode);
        if (isDeleted){
            return ResponseEntity.status(200).body(new ApiResponse(" course deleted successfully"));
        }else return ResponseEntity.status(400).body("course Code not found");
    }

    @PutMapping("/changeCourseName/{courseCode}")
    public ResponseEntity changeCourseName (@PathVariable String courseCode ,@RequestBody String courseName){
        boolean isChanged = courseService.changeCourseName(courseCode,courseName);
   if (isChanged){
       return ResponseEntity.status(200).body(new ApiResponse(" course name changed successfully"));
   }else return ResponseEntity.status(400).body("course Code not found");
    }



    @GetMapping("/CourseByStatus/{status}")
    public ResponseEntity getCourseByStatus(@PathVariable String status) {
        ArrayList<Course> courseByStatus =courseService.getCourseByStatus(status);
        if (courseService.getCourseByStatus(status) != null) {
            return ResponseEntity.status(200).body(courseByStatus);
        }
        return ResponseEntity.status(400).body(new ApiResponse("no courses founded"));
    }

@GetMapping("/weeksInSchedule/{courseCode}")
public ResponseEntity weeksInSchedule (@PathVariable String courseCode){
        return ResponseEntity.status(200).body(courseService.weeksInSchedule(courseCode));

}

}
