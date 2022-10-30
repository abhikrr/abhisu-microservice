package com.abhisu.microservice.service;

import com.abhisu.microservice.entity.User;

import java.util.List;

public interface UserService {
    public List<User> findAll();

    public User findById(Integer id);

    public User addUser(User user);

    public void deleteById(Integer id);
}
