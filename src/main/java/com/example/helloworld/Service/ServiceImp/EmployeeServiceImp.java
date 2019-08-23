package com.example.helloworld.Service.ServiceImp;

import com.example.helloworld.Service.EmployeeService;
import com.example.helloworld.model.Employee;
import com.example.helloworld.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImp implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public List<Employee> getAllEmployee(){
        List<Employee> result = employeeRepository.findAll();
        return result;
    }

}
