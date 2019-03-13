package com.example.TEP13.Backend.Application.controller;


import com.example.TEP13.Backend.Application.BackendApplication;
import com.example.TEP13.Backend.Application.domain.Card;
import com.example.TEP13.Backend.Application.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ActiveProfiles("integrationtest")
@SpringBootTest(classes = BackendApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class CardServiceIT {

    @Autowired
    private CardService cardService;

    @Test
    public void testCrud(){
        Card newCard = new Card();
        newCard.setType("Vraag");
        newCard.setDescription("ok");
        newCard.setTitle("Title");

        Card createdCard = this.cardService.saveCard(newCard);

        Assert.assertTrue(createdCard.getId() != 0);

    }


}
