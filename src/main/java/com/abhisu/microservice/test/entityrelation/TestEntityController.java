package com.abhisu.microservice.test.entityrelation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestEntityController {

    @Autowired
    private TestCourseRepository testCourseRepository;

    @Autowired
    private TestTeacherRepository testTeacherRepository;

    @Autowired
    private TestOrderRepository testOrderRepository;

    @Autowired
    private TestOrderItemRepository testOrderItemRepository;

    @GetMapping("/testcourses")
    public List<TestCourse> getAllCourse(){
        return  testCourseRepository.findAll();
    }

    @GetMapping("/testteachers")
    public List<TestTeacher> getAllTeachers(){
        return  testTeacherRepository.findAll();
    }

    @GetMapping("/testorders")
    public List<TestOrder> getAllOrders(){
        return  testOrderRepository.findAll();
    }

    @GetMapping("/testorderitems")
    public List<TestOrderItem> getAllOrderItems(){
        return  testOrderItemRepository.findAll();
    }

}
