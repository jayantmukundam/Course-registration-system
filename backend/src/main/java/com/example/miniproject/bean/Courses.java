package com.example.miniproject.bean;

import jakarta.persistence.*;

import java.time.Year;

@Entity
@Table
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer course_id;

    @Column(nullable=false, unique = true)
    private String course_code;

    @Column(nullable = false)
    private String name;

    @Column
    private String description;

    @Column(nullable = false)
    private Integer year;

    @Column(nullable = false)
    private Integer credits;

    @Column(nullable = false)
    private Integer term;

    @Column(nullable = false)
    private Integer capacity;





    @JoinColumn(name="employee_id")
    @ManyToOne(optional = true)
    private Employees employee_id;

    public Courses() {
    }

    public Courses(Integer course_id,String course_code, String name, String description, Integer year, Integer credits, Integer term, Integer capacity, Employees employee_id) {
        this.course_id = course_id;
        this.course_code = course_code;
        this.name = name;
        this.description = description;
        this.year = year;
        this.credits = credits;
        this.term = term;
        this.capacity = capacity;
        this.employee_id = employee_id;
    }

    public Courses(String course_code, String name, String description, Integer year, Integer credits, Integer term, Integer capacity) {
        this.course_code = course_code;
        this.name = name;
        this.description = description;
        this.year = year;
        this.credits = credits;
        this.term = term;
        this.capacity = capacity;
//        this.employee_id = employee_id;
    }


    public Integer getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }

    public String getCourse_code() {
        return course_code;
    }

    public void setCourse_code(String course_code) {
        this.course_code = course_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Employees getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Employees employee_id) {
        this.employee_id = employee_id;
    }
}
