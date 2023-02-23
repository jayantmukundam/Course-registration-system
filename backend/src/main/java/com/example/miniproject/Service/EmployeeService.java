package com.example.miniproject.Service;

import com.example.miniproject.DAO.Implementation.EmployeeDAOImpl;
import com.example.miniproject.bean.Employees;

import java.util.List;

public class EmployeeService {
    EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl(); //in DAO impl
    public Employees addEmp(Employees employee)
    { //called from controller
        return employeeDAO.addEmp(employee); //calls the DAO method
    }

//    public Employees login(Employees emp)
//    {
//        return employeeDAO.login(emp);
//    }

    public List<Employees> getEmployeeList() {

        return employeeDAO.getEmployeeList();
    }

}
