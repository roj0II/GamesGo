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
	
	public User(int id, String username, String name, String surname,
			String address, String phone, String email, String password, boolean admin) {
		super();
		this.id = id;
		
		this.username = username;
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.admin = admin;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	private String phone;
	private String email;
	private String password;
	private boolean admin;

}
