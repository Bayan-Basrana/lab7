package com.example.learningmanagementsystem.Controller;

import com.example.learningmanagementsystem.ApiREsponse.ApiResponse;
import com.example.learningmanagementsystem.Model.Student;
import com.example.learningmanagementsystem.Srevice.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/getStudent")
    public ResponseEntity getStudent (){
        ArrayList<Student> students=studentService.getStudent();
        return ResponseEntity.status(200).body(students);
    }

@PostMapping("/addStudent")
    public ResponseEntity addStudent (@RequestBody @Valid Student student, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        studentService.addStudent(student);
        return ResponseEntity.status(200).body(new ApiResponse("student added successfully"));
    }
@PutMapping("/updateStudent/{nationalID}")
    public ResponseEntity updateStudent (@PathVariable String nationalID ,@RequestBody @Valid Student student, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        boolean isUpdated= studentService.updateStudent(nationalID,student);
        if (isUpdated){
            return ResponseEntity.status(200).body(new ApiResponse("Student updated successfully"));
        }
else
    return ResponseEntity.status(400).body("ID not found");
    }

@DeleteMapping("/deleteStudent/{nationalID}")
public ResponseEntity deleteStudent (@PathVariable String nationalID){
        boolean isDeleted =studentService.deleteStudent(nationalID);
        if (isDeleted){
            return ResponseEntity.status(200).body(new ApiResponse("Student deleted successfully"));
        }else return ResponseEntity.status(400).body("id not found");
}

@GetMapping("/getStudentById/{nationalID}")
public ResponseEntity getStudentById (@PathVariable String nationalID){
        if (studentService.getStudentById(nationalID)!=null){
            return ResponseEntity.status(200).body(studentService.getStudentById(nationalID));
        }else return ResponseEntity.status(400).body("id not found");
}

@GetMapping("/orderStudentByGPA")
public ResponseEntity orderStudentByGPA (){
if (studentService.orderStudentByGPA()!=null){
    return ResponseEntity.status(200).body(studentService.orderStudentByGPA());
}else return ResponseEntity.status(400).body("There is no student ");
}

@GetMapping("/graduateStudent")
public ResponseEntity graduateStudent (){
        ArrayList<Student> graduate =studentService.graduateStudent();
    if (studentService.graduateStudent()!=null){
        return ResponseEntity.status(200).body(graduate);
    }
    else return ResponseEntity.status(400).body("There is no graduate Student ");
}



}
