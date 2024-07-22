package com.gamesgo.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Game implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	@OneToMany(mappedBy = "game",  cascade = CascadeType.REMOVE)
	private List<Storage> storage;
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
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getDownloadPrice() {
		return downloadPrice;
	}
	public void setDownloadPrice(float downloadPrice) {
		this.downloadPrice = downloadPrice;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<Gamegenre> getGameGenres() {
		return gameGenres;
	}
	public void setGameGenres(List<Gamegenre> gameGenres) {
		this.gameGenres = gameGenres;
	}
	public List<Storage> getStorage() {
		return storage;
	}
	public void setStorage(List<Storage> storage) {
		this.storage = storage;
	}
	public List<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	
	
}
