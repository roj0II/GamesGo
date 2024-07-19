package com.gamesgo.model;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity

public class Genre implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	
	private String name;

}
