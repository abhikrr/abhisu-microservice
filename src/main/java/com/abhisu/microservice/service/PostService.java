package com.abhisu.microservice.service;

import com.abhisu.microservice.entity.Post;

import java.util.List;

public interface PostService {
    List<Post> findAllPosts();

    Post findPostById(Integer id);

    Post addUserPost(Post post);
}
