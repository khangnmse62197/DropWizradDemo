package com.example.helloworld.api;

import com.example.helloworld.Service.EmployeeService;
import com.example.helloworld.Service.ServiceImp.EmployeeServiceImp;
import com.example.helloworld.model.Employee;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import io.dropwizard.jersey.PATCH;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

@Api
//@RequestMapping("/api")
@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
@Component
public class EmployeeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private  EmployeeService employeeService;

    @GET
    @Path("/get-all-emp")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<Employee> getAllEmp()  throws JsonGenerationException, JsonMappingException, IOException{
        employeeService = new EmployeeServiceImp();
        List<Employee> result = employeeService.getAllEmployee();
        return result;
    }

    @POST
    @Path("/add-emp")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public String addEmp(@RequestBody Employee employee)  {
        employeeService = new EmployeeServiceImp();
       int result = employeeService.save(employee);
       if(result ==1){
           return "SUCCESS";
       }else {
           return "UNSUCCESS";
       }
    }

    @PUT
    @Path("/update-emp")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public String updateEmp(@RequestBody Employee employee) {
        employeeService = new EmployeeServiceImp();
        int result = employeeService.update(employee);
        if(result ==1){
            return "SUCCESS";
        }else {
            return "UNSUCCESS";
        }
    }

    @GET
    @Path("/get-emp/{id}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Employee getEmpById(@PathParam("id") Long id)  {
        employeeService = new EmployeeServiceImp();
        Employee result = employeeService.getEmpById(id);
        return result;
    }

    @DELETE
    @Path("/delete-emp/{id}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public String deleteEmp(@PathParam("id") Long id)  {
        employeeService = new EmployeeServiceImp();
        int result = employeeService.delete(id);
        if(result ==1){
            return "SUCCESS";
        }else {
            return "UNSUCCESS";
        }
    }






}