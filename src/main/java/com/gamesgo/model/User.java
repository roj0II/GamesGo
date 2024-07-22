package com.gamesgo.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private int id;
	@OneToMany(mappedBy = "user",cascade = CascadeType.REMOVE)
	private List <Transaction> transcactionList;
	private String username;
	private String name;
	private String surname;
	private String address;
	private String phone;
	private String email;
	private String password;
	private boolean admin;

}
