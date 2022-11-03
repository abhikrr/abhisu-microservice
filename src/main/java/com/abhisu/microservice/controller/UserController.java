package com.abhisu.microservice.controller;

import com.abhisu.microservice.customException.DataNotFountException;
import com.abhisu.microservice.entity.User;
import com.abhisu.microservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserController {
    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping(path = "/users")
    public List<User> findAll() {
        return service.findAll();
    }

    @GetMapping(path = "/users/{id}")
    public EntityModel<User> findById(@PathVariable Integer id) {
        User user = service.findById(id);
        if (user == null) {
            throw new DataNotFountException("Data not found with id : " + id);
        }
        ;
        return EntityModel.of(user).add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).findAll()).withRel("all-users"));
    }

    @PostMapping("/users")
    public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
        service.addUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("users/{id}")
    public void deleteById(@PathVariable Integer id) {
        service.deleteById(id);
    }


}
