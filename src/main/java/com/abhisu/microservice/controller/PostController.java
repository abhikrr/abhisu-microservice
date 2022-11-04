package com.abhisu.microservice.controller;

import com.abhisu.microservice.customException.DataNotFountException;
import com.abhisu.microservice.entity.Post;
import com.abhisu.microservice.entity.User;
import com.abhisu.microservice.service.PostService;
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
public class PostController {
    private PostService postService;
    @Autowired
    public PostController(PostService postService){
        this.postService = postService;
    }

    @PostMapping
    public void createPostForUser(@PathVariable Integer id, @Valid @RequestBody Post post){

    }

    @GetMapping(path = "/posts")
    public List<Post> findAllPost() {

        return postService.findAllPosts();
    }

    @GetMapping(path = "/posts/{id}")
    public EntityModel<Post> findPostById(@PathVariable Integer id) {
        Post post = postService.findPostById(id);
        if (post == null) {
            throw new DataNotFountException("Data not found with id : " + id);
        }
        ;
        return EntityModel.of(post).add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).findAllPost()).withRel("all-posts"));
    }
}
