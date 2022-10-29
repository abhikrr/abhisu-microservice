package com.abhisu.microservice.test;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Timestamp;

//@Entity
//@Table(name = "test")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Test {
    private Integer id;
    private String name;
    private Integer age;
    private Double Salary;
    private Timestamp dob;
}
