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

    public User saveUser(User user){
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

    public User fillUser(String password, String firstName, String lastName, String email) {
        User user = new User();
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        saveUser(user);
        return user;
    }

    public User updateUser(long id, User user) {
        User userTarget = userRepository.findById(id).get();

        userTarget.setPassword(user.getPassword());
        userTarget.setFirstName(user.getFirstName());
        userTarget.setLastName(user.getLastName());
        userTarget.setEmail(user.getEmail());
        saveUser(userTarget);
        return userTarget;
    }

    public boolean deleteUser(long id) {
        if(this.userRepository.findById(id).isPresent()) {
            this.userRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }



}
