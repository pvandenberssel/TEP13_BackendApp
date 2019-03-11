package com.example.TEP13.Backend.Application.controller;

import com.example.TEP13.Backend.Application.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends CrudRepository<User,Long> {

}
