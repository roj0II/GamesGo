package com.gamesgo.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Transaction implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name = "idUser")
	private User user;
	@ManyToOne
	@JoinColumn(name = "idGame")
	private Game game;

	@OneToMany(mappedBy = "transaction", cascade = CascadeType.REMOVE)
	private List<Rent> rents;
	@OneToMany(mappedBy = "transaction", cascade = CascadeType.REMOVE)
	private List<Shipping> shipments;

}
