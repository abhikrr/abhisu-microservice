package com.abhisu.microservice.test.entityrelation;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "test_order_item")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TestOrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "todi_id")
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tord_id")
//    @JsonBackReference
//    @JsonManagedReference
    private TestOrder order;
}
