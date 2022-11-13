package com.abhisu.microservice.test.entityrelation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "test_course")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TestCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tcrs_id")
    private Integer id;

    @Column(name = "tcrs_title")
    private String title;

    @JsonManagedReference
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "ttcr_id")
    private TestTeacher testTeacher;
}
