package com.gamesgo.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Game implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	
	private String title;
	private String author;
	private Date releaseDate;
	private String description;
	private String photoUrl;
	private float price;
	private float downloadPrice;
	private String type;
	
	@OneToMany(mappedBy = "game",  cascade = CascadeType.REMOVE)
	private List<Gamegenre> gameGenres; 
	
}
