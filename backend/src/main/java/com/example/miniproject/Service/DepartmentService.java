package com.example.miniproject.Service;

import com.example.miniproject.DAO.Implementation.DepartmentDAOImpl;
import com.example.miniproject.DAO.Implementation.EmployeeDAOImpl;
import com.example.miniproject.bean.Department;
import com.example.miniproject.bean.Employees;

import java.util.List;

public class DepartmentService {

    DepartmentDAOImpl departmentDAO = new DepartmentDAOImpl(); //in DAO impl
    public boolean addDepartment(Department department)
    { //called from controller
        System.out.println("Error in DepartmentService");
        return departmentDAO.addDepartment(department); //calls the DAO method
    }

//    public Department login(Department dept)
//    {
//        return departmentDAO.login(dept);
//    }

    public List<Department> getDepartmentList() {

        return departmentDAO.getDepartmentList();
    }
}
