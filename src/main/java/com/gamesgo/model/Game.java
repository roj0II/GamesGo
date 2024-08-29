package com.gamesgo.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Game implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable=false, unique=true)
	private String title;
	@Column(nullable=false)
	private String author;
	@Column(nullable=false)
	private Date releaseDate;
	@Column(nullable=false, unique=true)
	private String description;
	@Column(nullable=false)
	private String photoUrl;
	@Column(nullable=false)
	private float priceRetail;
	@Column(nullable=false)
	private float priceDigital;
	
	
	@OneToMany(mappedBy = "game",  cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	private List<Gamegenre> gameGenres;
	@OneToOne(mappedBy = "game",  cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	private Storage storage;
	@OneToMany(mappedBy = "game",  cascade = CascadeType.REMOVE)
	private List<Transaction> transactions;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	public float getPriceRetail() {
		return priceRetail;
	}
	public void setPriceRetail(float price) {
		this.priceRetail = price;
	}
	public float getPriceDigital() {
		return priceDigital;
	}
	public void setPriceDigital(float priceDigital) {
		this.priceDigital = priceDigital;
	}
	public List<Gamegenre> getGameGenres() {
		return gameGenres;
	}
	public void setGameGenres(List<Gamegenre> gameGenres) {
		this.gameGenres = gameGenres;
	}
	public Storage getStorage() {
		return storage;
	}
	public void setStorage(Storage storage) {
		this.storage = storage;
	}
	public List<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	
	
}
