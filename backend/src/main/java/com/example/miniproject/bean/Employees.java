package com.example.miniproject.bean;

import jakarta.persistence.*;

import javax.json.bind.annotation.JsonbTransient;
import java.util.List;

@Entity
@Table
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employee_id;

    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String first_name;

    @Column
    private String last_name;

    @Column
    private String title;

    @Column(nullable = false)
    private String photo_path;

    // @Column(nullable = false)
    // private String dept_name;

    // @OneToMany(mappedBy = "employee_id",fetch = FetchType.LAZY)
    // private List<Courses> courses;

    @JoinColumn(name = "dept_id")
    @ManyToOne(optional = true)
    private Department empDepartment;

    public Employees() {
    }

    public Employees(Integer employee_id, String email, String password, String first_name, String last_name,
            String title, String photo_path, Department empDepartment, List<Courses> courses) {
        this.employee_id = employee_id;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.password = password;
        this.photo_path = photo_path;
        this.title = title;
        this.empDepartment = empDepartment;
        // this.courses = courses;
    }

    public Employees(String email, String password, String first_name, String last_name, String title,
            String photo_path, Department empDepartment, List<Courses> courses) {
        // this.employee_id = employee_id;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.password = password;
        this.photo_path = photo_path;
        this.title = title;
        this.empDepartment = empDepartment;
        // this.courses = courses;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Integer employee_id) {
        this.employee_id = employee_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhoto_path() {
        return photo_path;
    }

    public void setPhoto_path(String photo_path) {
        this.photo_path = photo_path;
    }

    public Department getEmpDepartment() {
        return empDepartment;
    }

    // public List<Courses> getCourses() {
    // return courses;
    // }
    //
    // public void setCourses(List<Courses> courses) {
    // this.courses = courses;
    // }

    public void setEmpDepartment(Department empDepartment) {
        this.empDepartment = empDepartment;
    }
    // public String getDept_name() {
    // return dept_name;
    // }
    //
    // public void setDept_name(String dept_name) {
    // this.dept_name = dept_name;
    // }

    // @JsonbTransient
    // public List<Courses> getCourses() {
    // return courses;
    // }
    //
    // public void setCourses(List<Courses> courses) {
    // this.courses = courses;
    // }
}
