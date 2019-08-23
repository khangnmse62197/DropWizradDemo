package com.example.helloworld.api;

import com.codahale.metrics.annotation.Timed;
import com.example.helloworld.DAO.InfoDao;
import com.example.helloworld.model.Info;
import com.example.helloworld.repository.InfoRepository;
import io.dropwizard.hibernate.UnitOfWork;
import io.swagger.annotations.Api;
import io.swagger.annotations.SwaggerDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RequestMapping("/resource")
@Controller
@Path("/resource")
@Api
@Produces(MediaType.APPLICATION_JSON)
public class MyResource {
    private InfoDao infoDao;

    public MyResource(InfoDao infoDao) {
        this.infoDao = infoDao;
    }

    @Autowired
    InfoRepository infoRepository;


    @GET
    @Timed
    @UnitOfWork
    @Path("/findAllEmp2")
    public List<Info> findAllEmp2() {

        return infoDao.findAll();
    }

    @GET
    @Timed
    @UnitOfWork
    @Path("/getbyId/{id}")
    public Info findAllEmp2(@PathParam("id") String id) {
        Info info = infoDao.findById(id);
        if(info == null){
            System.out.println("xxx "+id);
            System.out.println("NULLLLLLLLLLLLLLLLLLLLL");
        }else {
            System.out.println(info.getName());
        }
        return info;
    }

    @PUT
    @Timed
    @UnitOfWork
    @Path("/updateEmp")
    public void updateEmp(@RequestBody Info info) {
      //  System.out.println("All Emp  : " + infoDao.findAll());
       infoDao.updateEmp(info);
    }

    @POST
    @Timed
    @UnitOfWork
    @Path("/postEmp")
    public void postEmp(@RequestBody Info info) {
        //  System.out.println("All Emp  : " + infoDao.findAll());
        infoDao.updateEmp(info);
    }

    @DELETE
    @Timed
    @UnitOfWork
    @Path("/deleteEmp/{id}")
    public void deleteEmp(@PathParam("id") String id) {
//        System.out.println("xxx" + id);
//        infoDao.deleteEmp(id);
        Info info = infoDao.findById(id);
        infoDao.deleteEmp2(info);
    }

}
