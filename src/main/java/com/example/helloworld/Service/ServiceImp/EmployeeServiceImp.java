package com.example.helloworld.Service.ServiceImp;

import com.example.helloworld.Service.EmployeeService;
import com.example.helloworld.model.Employee;



import javax.persistence.*;
import java.util.List;
public class EmployeeServiceImp implements EmployeeService {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public List<Employee> getAllEmployee(){
        String qString = "SELECT e FROM Employee e";
        List<Employee> result = entityManager.createQuery(qString).getResultList();
        return  result;
    }

    public int save(Employee employee){
        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.getTransaction().commit();
        return 1;
    }

    public int update(Employee employee){
        entityManager.getTransaction().begin();
        entityManager.merge(employee);
        entityManager.getTransaction().commit();
        return 1;
    }

    public Employee getEmpById(long id){
//        try {
//            String qlString = "SELECT p FROM Employee p WHERE p.id = ?1";
//            TypedQuery<Employee> query = entityManager.createQuery(qlString, Employee.class);
//            query.setParameter(1, id);
//
//            return query.getSingleResult();
//        } catch (NoResultException e) {
//            return null;
//        }
        Employee emp = entityManager.find(Employee.class,id);
        if(emp != null){
            return emp;
        }
        return null;

    }

    public  int delete(long id){
        entityManager.getTransaction().begin();
        Employee emp = getEmpById(id);
        entityManager.remove(emp);
        entityManager.getTransaction().commit();
        return 1;
    }

}
