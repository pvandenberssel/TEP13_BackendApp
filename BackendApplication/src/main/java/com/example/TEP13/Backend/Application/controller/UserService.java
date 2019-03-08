package com.example.TEP13.Backend.Application.controller;

import com.example.TEP13.Backend.Application.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {
    @Autowired
    UserRepository userRepository;

    public Iterable<User> findAllUsers(){
        Iterable<User> users =userRepository.findAll();
        return users;
    }

    public User save(User user){
        return userRepository.save(user);
    }



}
