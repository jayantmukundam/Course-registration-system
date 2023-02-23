package com.example.miniproject.Service;

import com.example.miniproject.DAO.Implementation.CourseDAOImpl;
import com.example.miniproject.DAO.Implementation.CourseScheduleDAOImpl;
import com.example.miniproject.bean.CourseSchedule;

import java.util.List;

public class CourseScheduleService {
    CourseScheduleDAOImpl courseScheduleDAO = new CourseScheduleDAOImpl();
        public List<CourseSchedule> getCourseSchedule(Integer emp_id) {
        return courseScheduleDAO.getcourseScheduleList(emp_id);

    }
}
