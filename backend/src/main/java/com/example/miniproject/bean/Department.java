package com.example.miniproject.bean;

import jakarta.persistence.*;

@Entity
@Table
public class Department {
    @Id
    @Column(name ="dept_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer departmentID;

    @Column(name="dept_name",nullable = false)
    private String departmentName;

    @Column(name="Capacity",nullable = false)
    private Integer capacity;

    public Department() {
    }

    public Department(Integer departmentID,String departmentName, Integer capacity) {
        this.departmentID = departmentID;
        this.departmentName = departmentName;
        this.capacity = capacity;
    }

    public Department(String departmentName, Integer capacity) {
//        this.departmentID = departmentID;
        this.departmentName = departmentName;
        this.capacity = capacity;
    }

    public Integer getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(Integer departmentID) {
        this.departmentID = departmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}
