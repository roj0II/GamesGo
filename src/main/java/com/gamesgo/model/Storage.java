package com.gamesgo.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Storage implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "idGame")
	private Game game;
	@Column(nullable=false)
	private int amountRetail;
	@Column(nullable=false)
	private int amountDigital;

	public int getAmountRetail() {
		return amountRetail;
	}

	public void setAmountRetail(int amountRetail) {
		this.amountRetail = amountRetail;
	}

	public int getAmountDigital() {
		return amountDigital;
	}

	public void setAmountDigital(int amountDigital) {
		this.amountDigital = amountDigital;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
