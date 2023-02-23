package com.example.miniproject.DAO;

import com.example.miniproject.bean.Employees;

import java.util.List;

public interface EmployeeDAO {
    Employees addEmp (
            Employees employee
    );

    List<Employees> getEmployeeList();
//    Employees login(Employees emp);
}
