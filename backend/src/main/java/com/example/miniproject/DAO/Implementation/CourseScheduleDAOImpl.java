package com.example.miniproject.DAO.Implementation;

import com.example.miniproject.DAO.CourseScheduleDAO;
import com.example.miniproject.bean.CourseSchedule;
import com.example.miniproject.bean.Courses;
import com.example.miniproject.util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class CourseScheduleDAOImpl implements CourseScheduleDAO {
    @Override
    public boolean addCourseSchedule(CourseSchedule courseSchedule) {
        try (Session session = HibernateSessionUtil.getSession()) {
            Transaction t = session.beginTransaction();
            session.save(courseSchedule);
            t.commit();
            return true;
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return false;
        }
    }

        @Override
    public List<CourseSchedule> getcourseScheduleList(Integer id) {
        Session session = HibernateSessionUtil.getSession();
        List<CourseSchedule> courseScheduleList = new ArrayList<>();
        try {
//            Query query = session.createQuery("from Courses c where employee_id.employee_id is null and (c.day,c.time) not in(select day,time from Courses where employee_id.employee_id=:id) ");
            Query query = session.createQuery("from CourseSchedule cs where (cs.course_id.course_id in (select course_id from Courses where employee_id.employee_id is null)) and ((cs.day,cs.time) not in (select day,time from CourseSchedule where course_id.course_id in (select course_id from Courses where employee_id.employee_id=:id)))");


            query.setParameter("id", id);

          //  select cs.day,cs.room,cs.time,c.name,c.course_code from CourseSchedule cs join Courses c on cs.course_id=c.course_id where (c.employee_id is
          //  null) and ((cs.day,cs.time) not in (select day,time from CourseSchedule cor join Courses co on cor.course_id=co.course_id where co.employee_id=1));


            for (final Object courseSchedule : query.list()) {
                courseScheduleList.add((CourseSchedule) courseSchedule);
            }
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return courseScheduleList;
    }
}
