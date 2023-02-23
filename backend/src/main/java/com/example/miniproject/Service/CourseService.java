package com.example.miniproject.Service;

import com.example.miniproject.DAO.Implementation.CourseDAOImpl;
import com.example.miniproject.bean.Courses;

import java.util.List;

public class CourseService {
    CourseDAOImpl courseDAO = new CourseDAOImpl();
    public boolean addCourse(Courses course){
        return courseDAO.addCourse(course);
    }
//    public List<Courses> getCourses(Integer emp_id) {
//        return courseDAO.getCourses(emp_id);
//
//    }


    public boolean addCoursesToId(Integer emp_id,Integer c_id){
        return courseDAO.addCourseToId(emp_id,c_id);
    }


}
