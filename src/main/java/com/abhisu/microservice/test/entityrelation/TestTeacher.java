package com.abhisu.microservice.test.entityrelation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "test_teacher")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TestTeacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ttcr_id")
    private Integer id;

    @Column(name = "ttcr_first_ame")
    private String firstName;

    @Column(name = "ttcr_last_name")
    private  String lastName;

    @JsonManagedReference
    @JsonIgnore
    @OneToOne(mappedBy = "testTeacher")
    private TestCourse testCourse;
}
