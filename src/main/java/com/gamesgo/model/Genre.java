package com.gamesgo.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity

public class Genre implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	
	private String name;
	@OneToMany(mappedBy = "genre",  cascade = CascadeType.REMOVE)
	private List<Gamegenre> gameGenres;

	
}
