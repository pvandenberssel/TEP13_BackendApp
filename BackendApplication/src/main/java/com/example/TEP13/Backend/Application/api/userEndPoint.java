package com.example.TEP13.Backend.Application.api;

import com.example.TEP13.Backend.Application.controller.UserRepository;
import com.example.TEP13.Backend.Application.controller.UserService;
import com.example.TEP13.Backend.Application.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@Path("user")
@Component
public class userEndPoint {
    @Autowired
    UserService userService;

    @Path("all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers(){
        Iterable<User> users = userService.findAllUsers();
        return Response.ok(users).build();
    }

    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSingleUser(@PathParam("id") long id){
        Optional<User> user = userService.findUserById(id);
        return Response.ok(user).build();
    }


    @Path("new")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public long postUser(User user){
        User newUser = userService.save(new User());
        return newUser.getId();
    }

    @Path("login/{email}/{password}")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response loginUser(@PathParam("email") String email, @PathParam("password") String password) {
        User user = userService.findUserByEmail(email);
        if(user.getPassword().equals(password)) {
            return Response.ok(user).build();
        } else {
            return null;
        }
    }




}
