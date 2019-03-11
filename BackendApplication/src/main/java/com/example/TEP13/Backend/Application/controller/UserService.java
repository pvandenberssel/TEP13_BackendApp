package com.example.TEP13.Backend.Application.controller;

import com.example.TEP13.Backend.Application.domain.User;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Id;
import java.util.List;
import java.util.Optional;

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

    public Optional<User> findUserById(Long primaryKey){
        Optional<User> singleUser = userRepository.findById(primaryKey);
        return singleUser;
    }

    public User findUserByEmail (String email) {
        User singleEmail = userRepository.findByEmail(email);
        return singleEmail;
    }



}
