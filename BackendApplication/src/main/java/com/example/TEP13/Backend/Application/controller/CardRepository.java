package com.example.TEP13.Backend.Application.controller;

import com.example.TEP13.Backend.Application.domain.Card;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CardRepository extends CrudRepository<Card,Long> {

    @Query(value = "SELECT * FROM Card WHERE title LIKE %:searchWord% OR description LIKE %:searchWord% " , nativeQuery = true)

    List<Card> searchCards(@Param("searchWord") String searchWord);
}


