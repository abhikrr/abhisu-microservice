package com.abhisu.microservice.serviceImpl;

import com.abhisu.microservice.customException.DataNotFountException;
import com.abhisu.microservice.entity.User;
import com.abhisu.microservice.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private static List<User> users = new ArrayList<User>();
    private static int userCount = 0;
    static {
        users.add(new User(++userCount,"Abhishek", LocalDate.now()));
        users.add(new User(++userCount,"Kumar", LocalDate.now()));
        users.add(new User(++userCount,"Singh", LocalDate.now()));
    }
    @Override
    public List<User> findAll() {

        return users;
    }

    @Override
    public User findById(Integer id) {
        return users.stream().filter(data -> data.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public User addUser(User user) {
        user.setId(++userCount);
        users.add(user);
        return user;
    }

    @Override
    public void deleteById(Integer id) {
        users.removeIf(data -> data.getId().equals(id));
    }

}
