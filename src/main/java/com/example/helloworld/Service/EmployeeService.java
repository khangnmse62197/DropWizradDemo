package com.example.helloworld.Service;

import com.example.helloworld.model.Employee;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import java.util.List;
public interface EmployeeService {
    List<Employee> getAllEmployee();

}
