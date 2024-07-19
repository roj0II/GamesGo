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
	private String username;
	private String name;
	private String surname;
	private String address;
	private String phone;
	private String email;
	private String password;
	private boolean admin;

}
