package com.gamesgo.model;

import java.io.Serializable;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private int id;
    @Column
    private String username,name, surname;
    @Column
    private String address, phone, email, password;
    @Column
    private boolean admin;
    
    
}
