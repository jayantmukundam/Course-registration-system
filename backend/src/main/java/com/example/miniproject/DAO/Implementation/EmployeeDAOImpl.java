package com.example.miniproject.DAO.Implementation;

import com.example.miniproject.DAO.EmployeeDAO;
import com.example.miniproject.bean.Employees;
import com.example.miniproject.util.HibernateSessionUtil;
//import jakarta.persistence.Query;
import org.hibernate.query.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    public Employees addEmp (Employees employee) {
        try (Session session = HibernateSessionUtil.getSession()) {
            Transaction t = session.beginTransaction();

            // store photograph_path in binaryImageString

            String binaryImageString = employee.getPhoto_path();
            String curr_email = employee.getEmail();

            // replace photograph_path with ""
            employee.setPhoto_path("");

            // save this employee in database
            session.save(employee);

            // query for same employee
            Query q = session.createQuery("from Employees where email=:curr_email");
            q.setParameter("curr_email", curr_email);
            employee = (Employees) q.list().get(0);


            // name a file with employee_id
            String fileName = employee.getEmployee_id().toString()+".txt";

            // create new file with above name
            try {
                File file = new File(fileName);
                if (file.createNewFile()) {
                    try {
                        FileWriter fileWriter = new FileWriter(fileName);

                        // store binaryImageString in file
                        fileWriter.write(binaryImageString);
                        fileWriter.close();

                        // update photograph_path to file name
                        employee.setPhoto_path(fileName);

                        // update photograph_path in database
                        Query query = session.createQuery("update Employees set photo_path=:data where employee_id=:eid");
                        query.setParameter("eid", employee.getEmployee_id());
                        query.setParameter("data", fileName);

                        int count = query.executeUpdate();

                        t.commit();
                        return employee;
                    }
                    catch (IOException e) {
                        System.out.println("An error has occurred.");
                        e.printStackTrace();
                        return null;
                    }
                }
                else {
                    System.out.println("File already exists.");
                    return null;
                }
            }
            catch (IOException e) {
                System.out.println("An error has occurred.");
                e.printStackTrace();
                return null;
            }
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
    }



    @Override
    public List<Employees> getEmployeeList(){
        try (Session session = HibernateSessionUtil.getSession()){
            List<Employees> empList = new ArrayList<>();
            for (final Object d : session.createQuery("from Employees ").list()) {
                empList.add((Employees) d);
            }
            return empList;

        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
    }
}
