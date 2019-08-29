package com.example.helloworld.repository;

import com.example.helloworld.model.Info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository

public interface InfoRepository extends JpaRepository<Info,String> {
    Info findByEmpid(String empid);
 //   List<Info> findAll();

}
