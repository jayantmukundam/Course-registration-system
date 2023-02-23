package com.example.miniproject.controller;

import com.example.miniproject.Service.CourseScheduleService;
import com.example.miniproject.Service.CourseService;
import com.example.miniproject.bean.CourseSchedule;
import com.example.miniproject.bean.Courses;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URISyntaxException;
import java.util.List;

@Path("/course")
public class CourseController {

    @POST
    @Path("/add")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCourse(Courses course) throws URISyntaxException {
        boolean val = new CourseService().addCourse(course); //in service
        if (val == true)
            return Response.ok().entity("Success").build();
        else
            return Response.status(404).entity("Failure while adding course").build();
    }

    CourseService courseService = new CourseService();
    CourseScheduleService courseScheduleService = new CourseScheduleService();




    @GET
    @Path("/{emp_id}/add/{course_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addCourses(@PathParam("emp_id") Integer id,@PathParam("course_id") Integer course_id) {

        boolean val  = courseService.addCoursesToId(id,course_id);
//        System.out.println("courses****");
        List<CourseSchedule> courseScheduleList = courseScheduleService.getCourseSchedule(id);
        if (val == true)
            return Response.ok().entity(courseScheduleList).build();
        else
            return Response.status(404).entity("Failure while adding employeeID to course").build();
    }


}
