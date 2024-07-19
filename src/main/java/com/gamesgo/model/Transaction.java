package com.gamesgo.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Transaction implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private int id;
    
    private int idUser;
    private int idGame;
    

}
