package com.example.learningmanagementsystem.Srevice;

import com.example.learningmanagementsystem.Model.Course;
import com.example.learningmanagementsystem.Model.Registration;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

@Service
public class CourseService {
    ArrayList<Course> courses=new ArrayList<>();

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void addCourse (Course course){
         courses.add(course);
    }


    public boolean updateCourse (String courseCode,Course course){
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseCode().equalsIgnoreCase(courseCode)){
                courses.set(i,course);
                return true;
            }
        } return false;
    }


    public boolean deleteCourse (String courseCode ){
        for(Course c :courses){
            courses.removeIf(course -> course.getCourseCode().equalsIgnoreCase(courseCode));
       return true;
        }return false;
    }


public boolean changeCourseName (String courseCode, String courseName ){
        for(Course c: courses){
            if (c.getCourseCode().equalsIgnoreCase(courseCode))
                c.setCourseName(courseName);
            return true;
        }return false;

}

public ArrayList<Course> getCourseByStatus (String status){
        ArrayList<Course> coursesByStatus =new ArrayList<>();
        for (Course c:courses){
            if (c.getStatus().equalsIgnoreCase(status)){
                coursesByStatus.add(c);
            }
        }return coursesByStatus;
}

public long weeksInSchedule (String courseCode ) {
        for(Course c:courses){
    if (c.getCourseCode().equalsIgnoreCase(courseCode)   &&
            c.getScheduleStart() != null && c.getScheduleEnd()!=null  && c.getScheduleStart().isAfter(c.getScheduleEnd())){
        return ChronoUnit.WEEKS.between(c.getScheduleStart(),c.getScheduleEnd());
    }}
    return 0;
}

}
