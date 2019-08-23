package com.example.helloworld.api;

import com.example.helloworld.Service.EmployeeService;
import com.example.helloworld.model.Employee;
import io.dropwizard.jersey.PATCH;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

@Api
//@RequestMapping("/api")
@Path("/api")
public class EmployeeController {
    public EmployeeController(){
    }
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    EmployeeService employeeService;

    @GET
    @Path("/get-all-emp")
    public ResponseEntity<List<Employee>> getAllEmp() {
        List<Employee> result = employeeService.getAllEmployee();
        if(result == null){
            System.out.println("NULLLL");
            LOGGER.info("NULLLL" );
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}