package com.example.miniproject.controller;

import com.example.miniproject.DAO.DepartmentDAO;
import com.example.miniproject.DAO.Implementation.DepartmentDAOImpl;
import com.example.miniproject.Service.DepartmentService;
import com.example.miniproject.Service.EmployeeService;
import com.example.miniproject.bean.Department;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URISyntaxException;
import java.util.List;

@Path("/department")
public class DepartmentController {
    DepartmentDAO deptDAO = new DepartmentDAOImpl();

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)

    // ************WITHOUT SERVICES**********

//    public Response add_department(Department dept){
//        System.out.printf(String.valueOf(dept));
//        if(deptDAO.addDepartment(dept)){
//            return Response.status(200).entity("Success").build();
//        }
//
//        return Response.status(400).entity("Failure while adding department").build();
//    }

    public Response add_department(Department dept) throws URISyntaxException {
        System.out.printf(String.valueOf(dept));
        boolean val = new DepartmentService().addDepartment(dept);
        if(val==true){
            return Response.status(200).entity("Success").build();
        }

        return Response.status(400).entity("Failure while adding department").build();
//        return Response.status(400).build();
    }

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get_all_departments(){
        List<Department> depts = new DepartmentService().getDepartmentList();
        System.out.printf("Hello world");
        return Response.status(200).entity(depts).build();
    }

//    @GET
//    @Path("/get_employees/{dept_id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response get_department(@PathParam("dept_id") int d_id){
//        System.out.println(d_id);
//
//        List<Employee> employees = deptDAO.employeeListInDepartment(d_id);
//
//        return Response.status(200).entity(employees).build();
//    }
}
