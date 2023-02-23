package com.example.miniproject.controller;

import com.example.miniproject.Service.CourseScheduleService;
import com.example.miniproject.Service.CourseService;
import com.example.miniproject.bean.CourseSchedule;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.util.List;

@Path("/courseSchedule")
public class CourseScheduleController {

    CourseScheduleService courseScheduleService = new CourseScheduleService();
    @GET
    @Path("/{emp_id}/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCourseSchedule(@PathParam("emp_id") Integer id) {
        List<CourseSchedule> courseSchedule = courseScheduleService.getCourseSchedule(id);
//        System.out.println("courses**");
        return Response.ok().entity(courseSchedule).build();
    }
}
