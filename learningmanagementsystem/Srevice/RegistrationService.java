package com.example.learningmanagementsystem.Srevice;

import com.example.learningmanagementsystem.Model.Registration;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class RegistrationService {

    ArrayList<Registration> registrations= new ArrayList<>();

    public ArrayList<Registration> getRegistrations() {
        return registrations;
    }


    public void addRegistrations(Registration registration) {
registrations.add(registration);
    }

    public boolean updateRegistration (String registration_ID ,Registration registration){
        for (int i = 0; i < registrations.size() ; i++) {
            if (registrations.get(i).getRegistration_ID().equalsIgnoreCase(registration_ID)){
                registrations.set(i,registration);
                return true;
            }
        }return false;
    }


    public boolean deleteRegistration (String registration_ID){
for(Registration r:registrations){
    registrations.removeIf(registration -> registration.getRegistration_ID().equalsIgnoreCase(registration_ID));
return true;
}
return false;
    }


    public boolean updateSemester ( String registration_ID, int semester){
        for(Registration r:registrations){
            if(r.getRegistration_ID().equalsIgnoreCase(registration_ID) && semester>=1){
                r.setSemester(semester);
                return true;
            }
        }return false;
    }



 public int getEnrolledStudent (String courseCode){
        ArrayList<Registration> enrolled =new ArrayList<>();
        for(Registration r:registrations){
            if(r.getCourseCode().equalsIgnoreCase(courseCode)  && r.getStatus().equalsIgnoreCase("enrolled")){
                enrolled.add(r);
            }
        }return enrolled.size();
 }


 public boolean isSeatAvailable (String courseCode){
        for (Registration r:registrations) {
        if(r.getCourseCode().equalsIgnoreCase(courseCode)  && getEnrolledStudent(courseCode)< r.getMaxSeat()){
            return true;
        }
        }return false;
 }


}
