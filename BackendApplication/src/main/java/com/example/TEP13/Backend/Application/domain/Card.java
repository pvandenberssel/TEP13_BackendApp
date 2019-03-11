package com.example.TEP13.Backend.Application.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    long id;

    String type;
    String title;
    LocalDateTime date;
    String description;

    @ManyToOne
    User user;

    
}
