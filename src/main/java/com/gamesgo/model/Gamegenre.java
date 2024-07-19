package com.gamesgo.model;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Gamegenre implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@Id
	private int id;

	@ManyToOne
	@JoinColumn(name = "idGame")
	private Game game;
		
	@ManyToOne
	@JoinColumn(name = "idGenre")
	private Genre genre;
}
