package com.example.helloworld.model;
import lombok.Data;
import javax.persistence.*;
@Entity
@Table(name = "info")
@NamedQueries({
        @NamedQuery(name = "com.example.helloworld.model.info.findAll",
        query = "select e from Info e"),
        @NamedQuery(name="Info.findById",query = "select e from Info e where e.empid = :empid"),
        @NamedQuery(name="Info.deleteEmp",query = "delete  from  Info e where e.empid = :empid"),

})

@Data
public class Info {
    @Column(name = "name")
    private String name;

    @Id
    @Column(name = "empid")
    private String empid;


}
