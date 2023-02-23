package com.example.miniproject.DAO;

import com.example.miniproject.bean.CourseSchedule;
import com.example.miniproject.bean.Department;

import java.util.List;

public interface CourseScheduleDAO {
    boolean addCourseSchedule(CourseSchedule courseSchedule);
    List<CourseSchedule> getcourseScheduleList(Integer id);
}
