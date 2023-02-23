package com.example.miniproject.DAO;

import com.example.miniproject.bean.Courses;

import java.util.List;

public interface CourseDAO {

    boolean addCourse (Courses courses);
//    List<Courses> getCourses(Integer id);
    boolean addCourseToId (Integer id,Integer c_id);

}
