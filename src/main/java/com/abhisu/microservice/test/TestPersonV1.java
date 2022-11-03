package com.abhisu.microservice.test;

import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TestPersonV1 {
    private String name;
}
