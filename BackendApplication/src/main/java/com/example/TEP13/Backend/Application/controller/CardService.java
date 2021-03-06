package com.example.TEP13.Backend.Application.controller;

import com.example.TEP13.Backend.Application.domain.Card;
import com.example.TEP13.Backend.Application.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class CardService {
    @Autowired
    private CardRepository cardRepository;

    public Iterable<Card> findAllCards(){
        Iterable<Card> cards = cardRepository.findAll();
        return cards;
    }

    public Card saveCard(Card card){
        return cardRepository.save(card);
    }


    public void fillCard(String title, String Description, String Type, User user){
        Card card = new Card();
        card.setTitle(title);
        card.setDescription(Description);
        card.setType(Type);
        card.setUser(user);
        card.setDate(LocalDateTime.now());
        saveCard(card);
    }

    public Optional<Card> findCardById(Long primaryKey){
        Optional<Card> singleCard = cardRepository.findById(primaryKey);
        return singleCard;
    }

    public Card updateCard(long id, Card card){
        Card target = this.cardRepository.findById(id).get();
        target.setTitle(card.getTitle());
        target.setDescription(card.getDescription());
        target.setType(card.getType());
        target.setUser(card.getUser());
        target.setDate(card.getDate());
        return this.cardRepository.save(target);
    }

    public boolean deleteCardById(long id){
        if(this.cardRepository.findById(id).isPresent()){
            this.cardRepository.deleteById(id);
            return true;
        }else{
            return false;
        }


    }

    public List<Card> searchCards(String searchWord){
        List<Card> cards = cardRepository.searchCards(searchWord);
        return cards;
    }




}