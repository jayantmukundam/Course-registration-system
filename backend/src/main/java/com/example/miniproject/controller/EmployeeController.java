package com.example.miniproject.controller;
import com.example.miniproject.DAO.EmployeeDAO;
import com.example.miniproject.DAO.Implementation.EmployeeDAOImpl;
import com.example.miniproject.Service.DepartmentService;
import com.example.miniproject.Service.EmployeeService;
import com.example.miniproject.bean.Department;
import com.example.miniproject.bean.Employees;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
//import netscape.javascript.JSObject;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
//import jakarta.ws.rs.Path;

@Path("emp")

public class EmployeeController {

    @POST
    @Path("/register")

    @Produces(MediaType.APPLICATION_JSON) //return type
    @Consumes(MediaType.APPLICATION_JSON) //parameter
    public Response addEmp(Employees employee) throws URISyntaxException{

        if(employee.getEmpDepartment().getDepartmentID()!=2){
            return Response.status(401).build();
        }

        employee = new EmployeeService().addEmp(employee);
        if (employee !=null) {
            return Response.status(200).entity(employee).build();
        }
        else
            return Response.status(203).build();
    }


    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get_all_employees(){
        List<Employees> emp = new EmployeeService().getEmployeeList();
        System.out.printf("Hello world");
        return Response.status(200).entity(emp).build();
    }





}