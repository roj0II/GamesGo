package com.gamesgo.model;

import java.sql.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Game {
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
	
	
}
