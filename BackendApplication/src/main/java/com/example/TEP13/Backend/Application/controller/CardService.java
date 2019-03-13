package com.example.TEP13.Backend.Application.controller;

import com.example.TEP13.Backend.Application.domain.Card;
import com.example.TEP13.Backend.Application.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CardService {
    @Autowired
    private CardRepository cardRepository;

    public Iterable<Card> findAllCards(){
        Iterable<Card> cards = cardRepository.findAll();
        return cards;
    }


    @Transactional
    public Card saveCard(Card card){
        return cardRepository.save(card);
    }


    public void fillCard(String title, String Description, String Type, User user){
        Card card = new Card();
        card.setTitle(title);
        card.setDescription(Description);
        card.setType(Type);
        card.setUser(user);
        saveCard(card);
    }




}
