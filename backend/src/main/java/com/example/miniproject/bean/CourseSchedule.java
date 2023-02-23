package com.example.miniproject.bean;

import jakarta.persistence.*;
@Entity
@Table
public class CourseSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer course_schedule_id;

    @Column(nullable = false)
    private String time;

    @Column(nullable = false)
    private String day;

    @Column(nullable = false)
    private String room;

    @Column
    private String building;

    @JoinColumn(name="course_id")
    @ManyToOne(optional = true)
    private Courses course_id;

    public CourseSchedule(String time, String day, String room, String building) {
//        this.course_schedule_id = course_schedule_id;
        this.time = time;
        this.day = day;
        this.room = room;
        this.building = building;
//        this.course_id = course_id;
    }

    public CourseSchedule(Integer course_schedule_id,String time, String day, String room, String building,Courses course_id) {
        this.course_schedule_id = course_schedule_id;
        this.time = time;
        this.day = day;
        this.room = room;
        this.building = building;
        this.course_id = course_id;
    }

    public CourseSchedule() {
    }


    public Integer getCourse_schedule_id() {
        return course_schedule_id;
    }

    public void setCourse_schedule_id(Integer course_schedule_id) {
        this.course_schedule_id = course_schedule_id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public Courses getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Courses course_id) {
        this.course_id = course_id;
    }
}

