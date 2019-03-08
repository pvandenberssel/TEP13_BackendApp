package com.example.TEP13.Backend.Application.api;

import com.example.TEP13.Backend.Application.controller.UserRepository;
import com.example.TEP13.Backend.Application.controller.UserService;
import com.example.TEP13.Backend.Application.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("user")
@Component
public class userEndPoint {
    @Autowired
    UserService userService;


    @Autowired
    UserRepository yoyo;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response letsgo(){
        Iterable<User> users = userService.findAllUsers();
        return Response.ok(users).build();
    }

    @Path("hup")
    @GET
    public String hoi() {
        yoyo.save(new User());
        return "go";
    }

    



}
