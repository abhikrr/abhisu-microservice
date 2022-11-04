package com.abhisu.microservice.serviceImpl;

import com.abhisu.microservice.entity.Post;
import com.abhisu.microservice.repository.PostRepository;
import com.abhisu.microservice.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;
    @Autowired
    public PostServiceImpl(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> findAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post findPostById(Integer id) {
        return postRepository.findById(id).orElse(null);
    }

    @Override
    public Post addUserPost(Post post) {
        return postRepository.save(post);
    }
}
