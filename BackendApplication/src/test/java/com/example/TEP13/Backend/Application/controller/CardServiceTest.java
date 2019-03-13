package com.example.TEP13.Backend.Application.controller;

import com.example.TEP13.Backend.Application.domain.Card;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CardServiceTest {
    @InjectMocks
    private CardService cardService;
    @Mock
    private CardRepository cardRepository;

    private Card card = new Card();

    @Test
    public void testSaveCard(){
        Card result = new Card();
        Mockito.when(this.cardRepository.save(card)).thenReturn(result);
        Assert.assertEquals(result,this.cardRepository.save(card));
    }

    @Test
    public void testFindAll(){
        ArrayList<Card> cards = new ArrayList<Card>();
        Mockito.when(this.cardRepository.findAll()).thenReturn(cards);
        Assert.assertEquals(cards,this.cardRepository.findAll());
    }

}
