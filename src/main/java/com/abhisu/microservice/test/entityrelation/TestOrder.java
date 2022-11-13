package com.abhisu.microservice.test.entityrelation;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "test_order")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TestOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tord_id")
    private Integer id;

    @Column(name = "tord_desc")
    private String orderDesc;

//    @OneToMany
//    @JoinColumn(name = "tord_id")
//    private List<TestOrderItem> testOrderItems;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
//    @JsonManagedReference
//    @JsonBackReference
    @JsonIgnore
    private List<TestOrderItem> testOrderItems;
}
