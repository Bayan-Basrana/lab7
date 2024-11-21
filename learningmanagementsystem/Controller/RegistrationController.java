package com.example.learningmanagementsystem.Controller;

import com.example.learningmanagementsystem.ApiREsponse.ApiResponse;
import com.example.learningmanagementsystem.Model.Registration;
import com.example.learningmanagementsystem.Srevice.RegistrationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/registration")
@RequiredArgsConstructor
public class RegistrationController {
    private final RegistrationService registrationService;

    @GetMapping("/getRegistration")
    public ResponseEntity getRegistration (){
        ArrayList<Registration> registrations= registrationService.getRegistrations();
        return ResponseEntity.status(200).body(registrations);
    }

    @PostMapping("/addRegistration")
    public ResponseEntity addRegistration (@RequestBody @Valid Registration registration , Errors errors){
        if (errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        registrationService.addRegistrations(registration);
        return ResponseEntity.status(200).body(new ApiResponse("registration added successfully"));
    }
    @PutMapping("/updateRegistration/{registration_ID}")
    public ResponseEntity updateRegistration (@PathVariable String registration_ID ,@RequestBody @Valid Registration registration ,Errors errors){
        if (errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }

        boolean isUpdated = registrationService.updateRegistration(registration_ID ,registration);
    if (isUpdated){
        return ResponseEntity.status(200).body(new ApiResponse("registration updated successfully"));
    }
    else return ResponseEntity.status(400).body("registration ID not found");
    }


    @DeleteMapping("/deleteRegistration/{registration_ID}")
     public ResponseEntity deleteRegistration (@PathVariable String registration_ID){
        boolean isDeleted = registrationService.deleteRegistration(registration_ID);
     if(isDeleted){
         return ResponseEntity.status(200).body(new ApiResponse("registration deleted successfully"));
     }else return ResponseEntity.status(400).body("registration ID not found");
    }

@PutMapping("/updateSemester/{registration_ID}/{semester}")
    public ResponseEntity updateSemester (@PathVariable String registration_ID , @PathVariable int semester){
        boolean isUpdated= registrationService.updateSemester(registration_ID ,semester);
    if(isUpdated){
        return  ResponseEntity.status(200).body(new ApiResponse("semester updated successfully"));
    }else return ResponseEntity.status(400).body("registration ID not found");
    }

    @GetMapping("/isSeatAvailable/{courseCode}")
public ResponseEntity isSeatAvailable (@PathVariable String courseCode){
        boolean isAvailable = registrationService.isSeatAvailable(courseCode);
if (isAvailable){
    return  ResponseEntity.status(200).body("there is seats Available  ");
}
     else return ResponseEntity.status(400).body(" no seat Available ");
    }



}
