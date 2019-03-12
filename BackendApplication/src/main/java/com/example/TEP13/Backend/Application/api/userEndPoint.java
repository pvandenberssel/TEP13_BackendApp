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

@Path("users")
@Component
public class userEndPoint {
    @Autowired
    UserService userService;

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

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response newUser(User user){
        user = userService.saveUser(user);
        return Response.accepted(user.getId()).build();
    }

    @Path("fill")
    public Response fillUser() {
        userService.fillUser("geheim1", "Piet", "Puk", "Piet.Puk@youngcolfield.nl");
        userService.fillUser("geheim2", "Bart", "de Vries", "Bart.Devries@youngcolfield.nl");
        userService.fillUser("geheim3", "Jasper", "Lustig", "Jasper.Lustig@youngcolfield.nl");
        userService.fillUser("geheim4", "Pim", "van den Bersselaar", "Pim.vandenBersselaar@youngcolfield.nl");
        return Response.ok().build();
    }

    @Path("{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateSingleUser(@PathParam("id") long id, User user) {

        Optional<User> optionalTarget = this.userService.findUserById(id);
        if (optionalTarget.isPresent()) {
            User target = optionalTarget.get();
            target.setEmail(user.getEmail());
            target.setFirstName(user.getFirstName());
            target.setLastName(user.getLastName());
            target.setPassword(user.getPassword());

            return Response.ok(this.userService.saveUser(target)).build();
        } else {
            return Response.status(404).build();
        }
    }


    @Path("login/{email}/{password}")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response loginUser(@PathParam("email") String email, @PathParam("password") String password) {
        User user = userService.findUserByEmail(email);
        if (user.getPassword().equals(password)) {
            return Response.ok(user).build();
        } else {
            return null;
        }
    }
}
