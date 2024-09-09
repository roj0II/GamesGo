package com.gamesgo.model;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Genre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	@OneToMany(mappedBy = "genre", cascade = CascadeType.REMOVE)
	private List<Gamegenre> gameGenres;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Gamegenre> getGameGenres() {
		return gameGenres;
	}

	public void setGameGenres(List<Gamegenre> gameGenres) {
		this.gameGenres = gameGenres;
	}

}
