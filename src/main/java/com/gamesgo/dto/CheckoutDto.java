package com.gamesgo.dto;

public class CheckoutDto {

	// Dati utente, Ottenuti dal loggedUser.
	private String userAddress;
	private String userEmail;
	private String userPhone;
	private String userName;
	private String userSurname;
	// private boolean admin; se vogliamo, facciamo che all'admin si applica 20% di sconto automaticamente.EXTRA
	
	// Dati gioco, Ottenuti dal gioco selezionato per l'acquisto/affitto.
	private String gameTitle;
	private float gamePrice; // in base alla scelta dell'utente verrà usato quello retail o digital.
	private String gamePhotoUrl;
	
	
	
	
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserSurname() {
		return userSurname;
	}
	public void setUserSurname(String userSurname) {
		this.userSurname = userSurname;
	}
	public String getGameTitle() {
		return gameTitle;
	}
	public void setGameTitle(String gameTitle) {
		this.gameTitle = gameTitle;
	}
	public float getGamePrice() {
		return gamePrice;
	}
	public void setGamePrice(float gamePrice) {
		this.gamePrice = gamePrice;
	}
	public String getGamePhotoUrl() {
		return gamePhotoUrl;
	}
	public void setGamePhotoUrl(String gamePhotoUrl) {
		this.gamePhotoUrl = gamePhotoUrl;
	}

}
