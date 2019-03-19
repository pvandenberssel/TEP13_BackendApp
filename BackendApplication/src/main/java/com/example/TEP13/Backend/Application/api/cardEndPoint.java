package com.example.TEP13.Backend.Application.api;

import com.example.TEP13.Backend.Application.controller.CardService;
import com.example.TEP13.Backend.Application.controller.UserService;
import com.example.TEP13.Backend.Application.domain.Card;
import com.example.TEP13.Backend.Application.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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


    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSingleCard(@PathParam("id") long id){
        Optional<Card> singleCard = cardService.findCardById(id);
        return Response.ok(singleCard).build();
    }

    @Path("new")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response newCard(Card card){
        if(card.getUser().getId() != 0){
            card.setDate(LocalDateTime.now());
            card = cardService.saveCard(card);
            return Response.accepted(card.getId()).build();
        }else{
            return Response.ok("fail").build();
        }
    }

    @Path("fill")
    public Response fillCard(){
        cardService.fillCard("Huisgenoot","Omdat een van mijn huisgenootjes weggaat uit huis ben ik op zoek naar een nieuwe huisgenoot.","Vraag",userService.fillUser("geheim1", "Piet", "Puk", "Piet.Puk@youngcolfield.nl"));
        cardService.fillCard("Spaanse les","Aangezien ik een vakantie heb geboekt naar Spanje en graag in het Spaans een drankje zou willen bestellen ben ik op zoek naar iemand die me een klein woordtje Spaans kan bijbrengen.","Vraag",userService.fillUser("geheim2", "Bart", "de Vries", "Bart.Devries@youngcolfield.nl"));
        cardService.fillCard("Tweezit bank","Wegens een verhuizing en ruimtegebrek biedt ik mijn mooie tweezit bank te koop aan tegen elk aannemelijk bod","Aanbod",userService.fillUser("geheim4", "Pim", "van den Bersselaar", "Pim.vandenBersselaar@youngcolfield.nl"));
        cardService.fillCard("Saxofoon les","Nadat ik in een opwelling een saxofoon heb gekocht ben ikk nu op zoek naar iemand die mij les zou kunnen geven.","Vraag",userService.findUserByEmail("Bart.Devries@youngcolfield.nl"));
        cardService.fillCard("Nieuwe eigenaar voor puppy","Wegens tijdgebrek en ruimtegebrek ben ik opzoek naar een andere eigenaar voor mijn hond.","Aanbod",userService.fillUser("geheim3", "Jasper", "Lustig", "Jasper.Lustig@youngcolfield.nl"));
        return Response.ok().build();
    }

    @Path("update/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public  Response UpdateCard(@PathParam("id") long id, Card card){
        Card updatedcard = cardService.updateCard(id,card);
        return Response.accepted(updatedcard).build();
    }

    @Path("delete/{id}")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response DeleteCard(@PathParam("id") long id){
        boolean deleted = cardService.deleteCardById(id);
        return Response.ok(deleted).build();
    }

    @Path("search/{searchWord}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response searchCards(@PathParam("searchWord") String searchWord) {
        List<Card> cardList = cardService.searchCards(searchWord);
        System.out.println("hiero:" + cardList);
        return Response.ok(cardList).build();
    }







}
