package com.abhisu.microservice.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.LocalDate;

@RestController
@Slf4j
public class TestController {
    private final Test test;
    public TestController(){
        this.test = new Test(1,"Xml Data",30,1000.00, new Timestamp(LocalDate.now().toEpochDay()));
    }

    @GetMapping("/test/string")
    public String getString(){
        return "Hello World";
    }

    @GetMapping(value = "/testXml", produces = MediaType.APPLICATION_XML_VALUE)
    public Test getXmlTest(){
        return this.test;
    }

    @GetMapping(value = "/testJson", produces = MediaType.APPLICATION_JSON_VALUE)
    public Test getJsonTest(){
        return this.test;
    }
}
