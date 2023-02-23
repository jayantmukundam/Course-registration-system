package com.example.miniproject.DAO;

import com.example.miniproject.bean.Department;

import java.util.List;

public interface DepartmentDAO {
    boolean addDepartment(Department deptObj);
    List<Department> getDepartmentList();

}
