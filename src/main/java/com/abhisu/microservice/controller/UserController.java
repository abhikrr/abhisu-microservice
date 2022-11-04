package com.abhisu.microservice.controller;

import com.abhisu.microservice.customException.DataNotFountException;
import com.abhisu.microservice.entity.Post;
import com.abhisu.microservice.entity.User;
import com.abhisu.microservice.service.PostService;
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
    private UserService userService;
    private PostService postService;

    @Autowired
    public UserController(UserService userService, PostService postService) {

        this.userService = userService;
        this.postService = postService;
    }

    @GetMapping(path = "/users")
    public List<User> findAll() {

        return userService.findAll();
    }

    @GetMapping(path = "/users/{id}/posts")
    public List<Post> findPostById(@PathVariable Integer id) {
        User user = userService.findById(id);
        if (user == null) {
            throw new DataNotFountException("Data not found with id : " + id);
        }
        return user.getPosts();
    }

    @GetMapping(path = "/users/{id}")
    public EntityModel<User> findById(@PathVariable Integer id) {
        User user = userService.findById(id);
        if (user == null) {
            throw new DataNotFountException("Data not found with id : " + id);
        }
        ;
        return EntityModel.of(user).add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).findAll()).withRel("all-users"));
    }



    @PostMapping("/users")
    public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
        userService.addUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PostMapping("/users/{id}/posts")
    public ResponseEntity<Post> addUserPost(@PathVariable int id, @Valid @RequestBody Post post) {
        User user = userService.findById(id);
        if (user == null) {
            throw new DataNotFountException("Data not found with id : " + id);
        }
        post.setUser(user);
        Post savedPost = postService.addUserPost(post);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedPost.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("users/{id}")
    public void deleteById(@PathVariable Integer id) {
        userService.deleteById(id);
    }


}
