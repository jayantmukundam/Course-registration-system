package com.example.miniproject.DAO.Implementation;

import com.example.miniproject.DAO.CourseDAO;
import com.example.miniproject.bean.Courses;
import com.example.miniproject.util.HibernateSessionUtil;
import jakarta.persistence.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.example.miniproject.DAO.CourseDAO;

import java.util.ArrayList;
import java.util.List;

public class CourseDAOImpl implements CourseDAO{
    @Override
    public boolean addCourse(Courses course) {
        try (Session session = HibernateSessionUtil.getSession()) {
            Transaction t = session.beginTransaction();
            session.save(course);
            t.commit();
            return true;
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return false;
        }
    }

    @Override
    public boolean addCourseToId(Integer id,Integer c_id) {
        try (Session session = HibernateSessionUtil.getSession()) {
            Transaction t = session.beginTransaction();

            Query query = session.createQuery("update Courses c set c.employee_id.employee_id=:eid where c.course_id =: cid");
            query.setParameter("eid", id);
            query.setParameter("cid", c_id);

            int count = query.executeUpdate();

            t.commit();
            return true;
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return false;
        }
    }

//    @Override
//    public List<Courses> getCourses(Integer id) {
//        Session session = HibernateSessionUtil.getSession();
//        List<Courses> courses = new ArrayList<>();
//        try {
//            Query query = session.createQuery("from Courses c,CourseSchedule cs where employee_id.employee_id is null and (c.day,c.time) not in(select day,time from Courses where employee_id.employee_id=:id) ");
//            query.setParameter("id", id);
//
//
//            for (final Object course : query.list()) {
//                courses.add((Courses) course);
//            }
//        } catch (HibernateException exception) {
//            System.out.print(exception.getLocalizedMessage());
//        }
//        return courses;
//    }
}
