package com.gamesgo.dto;

import java.sql.Date;


public class GameDto {
private int id;
private String title;
private String author;
private Date releaseDate;
private String description;
private String photoUrl;
private float priceRetail;
private float priceDigital;
	
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
public void setPriceRetail(float priceRetail) {
	this.priceRetail = priceRetail;
}
public float getPriceDigital() {
	return priceDigital;
}
public void setPriceDigital(float priceDigital) {
	this.priceDigital = priceDigital;
}
	
}
