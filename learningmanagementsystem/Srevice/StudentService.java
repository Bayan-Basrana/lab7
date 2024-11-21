package com.example.learningmanagementsystem.Srevice;

import com.example.learningmanagementsystem.Model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service

public class StudentService {
    ArrayList<Student> students=new ArrayList<>();

    public ArrayList<Student> getStudent (){
        return students;
    }


    public void addStudent (Student student){
        students.add(student);
    }


    public boolean updateStudent (String nationalID, Student student){
        for (int i = 0; i <students.size(); i++) {
            if (students.get(i).getNationalID().equalsIgnoreCase(nationalID)){
                students.set(i,student);
                return true;}
        }return false;
    }


    public boolean deleteStudent ( String nationalID){
        for (Student s: students) {
            students.removeIf(student -> student.getNationalID().equalsIgnoreCase(nationalID));
            return true;
        }return false;
    }

    public Student getStudentById (String nationalID) {
        for (Student s : students) {
            if (s.getNationalID().equalsIgnoreCase(nationalID)) {
                return s;}
        }            return null;
    }

     public Map<String ,ArrayList<Student>> orderStudentByGPA () {
         ArrayList<Student> excellent = new ArrayList<>();
         ArrayList<Student> veryGood = new ArrayList<>();
         ArrayList<Student> good = new ArrayList<>();
         Map<String, ArrayList<Student>> studentByGPA = null;
         for (Student s : students) {
             if (s.getGPA() >= 3.5 && s.getGPA() <= 5) {
                 excellent.add(s);
             }
             if (s.getGPA() >= 3 && s.getGPA() < 3.5) {
                 veryGood.add(s);
             }
             if (s.getGPA() >= 2 && s.getGPA() < 3) {
                 good.add(s);
             }
             studentByGPA = new HashMap<>();
             studentByGPA.put("excellent", excellent);
             studentByGPA.put("veryGood", veryGood);
             studentByGPA.put("good", good);
         }
         return studentByGPA;
     }


     public ArrayList<Student> graduateStudent (){
        ArrayList<Student> graduate = new ArrayList<>();
        for (Student s:students){
            if (s.getStatus().equalsIgnoreCase("graduate")){
                graduate.add(s);
            }
        }return graduate;
     }

}
