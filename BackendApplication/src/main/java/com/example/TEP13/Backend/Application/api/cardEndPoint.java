package com.example.TEP13.Backend.Application.api;

import com.example.TEP13.Backend.Application.controller.CardService;
import com.example.TEP13.Backend.Application.controller.UserService;
import com.example.TEP13.Backend.Application.domain.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("card")
@Component
public class cardEndPoint {
    @Autowired
    CardService cardService;

    @Autowired
    UserService userService;

    @Path("all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCards(){
        Iterable<Card> cards = cardService.findAllCards();
        return Response.ok(cards).build();
    }

    @Path("new")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response newCard(Card card){
        card = cardService.saveCard(card);
        return Response.accepted(card.getId()).build();
    }

    @Path("fill")
    public Response fillCard(){
        cardService.fillCard("ok","blablba","dummy",userService.fillUser("geheim1", "Piet", "Puk", "Piet.Puk@youngcolfield.nl"));
        cardService.fillCard("ok23","bddda","dummy2",userService.fillUser("geheim2", "Bart", "de Vries", "Bart.Devries@youngcolfield.nl"));
        cardService.fillCard("ok34","asdfkjanfds","dummy4",userService.fillUser("geheim2", "Bart", "de Vries", "Bart.Devries@youngcolfield.nl"));
        cardService.fillCard("123132","asdfnalkfdsn","dummy5",userService.fillUser("geheim2", "Bart", "de Vries", "Bart.Devries@youngcolfield.nl"));
        cardService.fillCard("433542","ldaslldald","dummy6",userService.fillUser("geheim3", "Jasper", "Lustig", "Jasper.Lustig@youngcolfield.nl"));
        return Response.ok().build();
    }


}
