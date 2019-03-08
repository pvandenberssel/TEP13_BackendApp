package com.example.TEP13.Backend.Application.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    long id;

    String firstName;
    String lastName;
    String email;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
