package com.example.TEP13.Backend.Application.controller;

import org.springframework.beans.factory.annotation.Autowired;

public class UserService {
    @Autowired
    UserRepository userRepository;

    public Iterable<User> findAllUsers(){
        Iterable<User> users =userRepository.findAll();
        return users;
    }

}
