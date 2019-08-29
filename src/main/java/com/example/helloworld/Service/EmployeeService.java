package com.example.helloworld.Service;

import com.example.helloworld.model.Employee;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {
   public List<Employee> getAllEmployee();
   int save(Employee employee);
   int update(Employee employee);
   Employee getEmpById(long id);
   int delete(long id);



}
