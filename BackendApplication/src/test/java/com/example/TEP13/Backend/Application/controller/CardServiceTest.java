package com.example.TEP13.Backend.Application.controller;

import com.example.TEP13.Backend.Application.domain.Card;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CardServiceTest {

    @InjectMocks
    private CardService cardService;

    @Mock
    private CardRepository cardRepository;;

    @Test
    public void testSaveCard(){
        Card card = new Card();
        Mockito.when(this.cardRepository.save(card)).thenReturn(card);
        Assert.assertEquals(card, this.cardService.saveCard(card));
    }

}
