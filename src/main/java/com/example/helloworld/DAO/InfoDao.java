package com.example.helloworld.DAO;
import com.example.helloworld.model.Info;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;
public class InfoDao  extends AbstractDAO<Info>{

    public InfoDao(SessionFactory factory) {
        super(factory);
    }
    public List<Info> findAll() {
        return list(namedQuery("com.example.helloworld.model.info.findAll"));
    }

    public void updateEmp(Info info){
       persist(info);
    }

    public Info findById(String empId){
        return uniqueResult(namedQuery("Info.findById").setParameter("empid",empId));

    }

    public void deleteEmp(String empId){
         namedQuery("Info.deleteEmp").setParameter("empid",empId);

    }
    public void deleteEmp2(Info info){
       currentSession().delete(info);

    }






}
