package com.example.TEP13.Backend.Application.controller;

import com.example.TEP13.Backend.Application.domain.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CardService {
    @Autowired
    CardRepository cardRepository;

    public Iterable<Card> findAllCards(){
        Iterable<Card> cards = cardRepository.findAll();
        return cards;
    }

    public Card saveCard(Card card){
        return cardRepository.save(card);
    }




}
