package com.abhisu.microservice.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    private Integer id;

    @Size(min = 2, message = "Name Should have atleast two character")
    private String name;

    @Past(message = "Birth date should be in past")
    private LocalDate birthDate;
}
