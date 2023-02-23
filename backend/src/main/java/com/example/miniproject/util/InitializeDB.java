package com.example.miniproject.util;

import com.example.miniproject.DAO.CourseDAO;
import com.example.miniproject.DAO.CourseScheduleDAO;
import com.example.miniproject.DAO.DepartmentDAO;
import com.example.miniproject.DAO.Implementation.CourseDAOImpl;
import com.example.miniproject.DAO.Implementation.CourseScheduleDAOImpl;
import com.example.miniproject.DAO.Implementation.DepartmentDAOImpl;
import com.example.miniproject.bean.CourseSchedule;
import com.example.miniproject.bean.Courses;
import com.example.miniproject.bean.Department;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InitializeDB {
    public static void main(String[] args) {

//        ************DEPARTMENT**************
        List<List<Object>> department  = Arrays.asList(
        Arrays.asList("Admission",50), Arrays.asList("Faculty",100), Arrays.asList("Placement",10)
        );


//        **********COURSESCHEDULE************
        List<List<Object>> courseSchedule = Arrays.asList(
                //0 algorithms
                Arrays.asList("09:30:00", "Monday", "R103", "Ramanujan"),
                //1 machine learning
                Arrays.asList("11:15:00", "Monday", "R103", "Ramanujan"),
                //2 machine learning
                Arrays.asList("16:00:00", "Monday", "R105", "Ramanujan"),
                //3 software systems
                Arrays.asList("09:30:00", "Tuesday", "R203", "Ramanujan"),
                //4 mathematics for machine learning
                Arrays.asList("11:15:00", "Tuesday", "R203", "Ramanujan"),
                //5 algorithms
                Arrays.asList("09:30:00", "Wednesday", "R103", "Ramanujan"),
                //6 concrete mathematics
                Arrays.asList("11:15:00", "Wednesday", "R103", "Ramanujan"),
                //7 machine learning
                Arrays.asList("14:00:00", "Wednesday", "R103", "Ramanujan"),
                //8 software systems
                Arrays.asList("09:30:00", "Thursday", "R103", "Ramanujan"),
                //9 mathematics for machine learning
                Arrays.asList("11:15:00", "Thursday", "R103", "Ramanujan"),
                //10 concrete mathematics
                Arrays.asList("14:00:00", "Thursday", "R103", "Ramanujan"),
                //11 software systems
                Arrays.asList("09:30:00", "Friday", "R103", "Ramanujan"),
                //12 algorithms
                Arrays.asList("09:30:00", "Saturday", "R103", "Ramanujan"),
                // 13 software systems
                Arrays.asList("09:30:00", "Monday", "R203", "Ramanujan")
        );

        // ********** COURSE **********

        List<List<Object>> courses = Arrays.asList(
                Arrays.asList("CS-511","Algorithms",null,2022,4,1,150),
                Arrays.asList("CS-512","Concrete Mathematics",null,2022,4,1,150),
                Arrays.asList("CS-513","Software Systems",null,2022,4,1,150),
                Arrays.asList("AI-511","Machine Learning",null,2022,4,1,150),
                Arrays.asList("AI-512","Mathematics for machine learning",null,2022,4,1,150)
        );

        DepartmentDAO deptDAO = new DepartmentDAOImpl();
        CourseScheduleDAO courseScheduleDAO = new CourseScheduleDAOImpl();
        CourseDAO courseDAO = new CourseDAOImpl();

       for(List<Object> dept:department){
           Department d = new Department((String)dept.get(0),(Integer) dept.get(1));
           deptDAO.addDepartment(d);

       }
        List<CourseSchedule> courseScheduleList = new ArrayList<>();
        for(List<Object> cs:courseSchedule){
            CourseSchedule c = new CourseSchedule((String)cs.get(0),(String) cs.get(1),(String) cs.get(2),(String) cs.get(3));
            courseScheduleList.add(c);
        }

        List<Courses> coursesList = new ArrayList<>();
        for(List<Object> course:courses){
            Courses c = new Courses((String)course.get(0),(String)course.get(1),(String)course.get(2),(Integer) course.get(3),(Integer) course.get(3),(Integer) course.get(3),(Integer) course.get(3));
            coursesList.add(c);
        }

        courseScheduleList.get(0).setCourse_id(coursesList.get(0));
        courseScheduleList.get(1).setCourse_id(coursesList.get(3));
        courseScheduleList.get(2).setCourse_id(coursesList.get(3));
        courseScheduleList.get(3).setCourse_id(coursesList.get(2));
        courseScheduleList.get(4).setCourse_id(coursesList.get(4));
        courseScheduleList.get(5).setCourse_id(coursesList.get(0));
        courseScheduleList.get(6).setCourse_id(coursesList.get(1));
        courseScheduleList.get(7).setCourse_id(coursesList.get(3));
        courseScheduleList.get(8).setCourse_id(coursesList.get(2));
        courseScheduleList.get(9).setCourse_id(coursesList.get(4));
        courseScheduleList.get(10).setCourse_id(coursesList.get(1));
        courseScheduleList.get(11).setCourse_id(coursesList.get(2));
        courseScheduleList.get(12).setCourse_id(coursesList.get(0));
        courseScheduleList.get(13).setCourse_id(coursesList.get(2));

        for(Courses c:coursesList){
            courseDAO.addCourse(c);
        }

        for(CourseSchedule c:courseScheduleList){
            courseScheduleDAO.addCourseSchedule(c);
        }





    }
}
