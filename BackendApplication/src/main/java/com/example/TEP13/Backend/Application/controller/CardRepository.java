package com.example.TEP13.Backend.Application.controller;

import com.example.TEP13.Backend.Application.domain.Card;
import org.springframework.data.repository.CrudRepository;

public interface CardRepository extends CrudRepository<Card,Long> {

}
