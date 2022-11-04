package com.abhisu.microservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "post")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Post {

    @Id
    @GeneratedValue
    private Integer id;

    @Size(min = 10)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties
    private User user;
}
