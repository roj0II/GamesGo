package com.gamesgo.dto;

import java.util.Date;

public class CheckoutDto {

	// Dati per sapere se è online o fisico | compra o affitta
	private boolean online;
	private boolean buy; 
	
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
	
	// Dati consegna - fisico
	private String shippingAddress; // se compriamo fisicamente, servirà anche questo campo.
	// Dati consegna - fisico / online
	private String shippingEmail;
	private String shippingPhone;
	
	// Dati affitto
	private int rentDays;
	
	// Dati pagamento con carta:
	private String paymentCardCode;
	private String paymentCvv;
	private String paymentName;
	private String paymentSurname;
	private Date paymentCardExpiration;
	
	// Dati pagamento paypal:
	private String paymentEmail;
	
	// Dati fatturazione:
	private String transactionAddress;
	private String transactionPhone;
	private String transactionEmail;
	// i soldi che paga sarà calcolato nel controller.
	
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
	public boolean isOnline() {
		return online;
	}
	public void setOnline(boolean online) {
		this.online = online;
	}
	public boolean isBuy() {
		return buy;
	}
	public void setBuy(boolean buy) {
		this.buy = buy;
	}
	public String getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public String getShippingEmail() {
		return shippingEmail;
	}
	public void setShippingEmail(String shippingEmail) {
		this.shippingEmail = shippingEmail;
	}
	public String getShippingPhone() {
		return shippingPhone;
	}
	public void setShippingPhone(String shippingPhone) {
		this.shippingPhone = shippingPhone;
	}
	public int getRentDays() {
		return rentDays;
	}
	public void setRentDays(int rentDays) {
		this.rentDays = rentDays;
	}
	public String getPaymentCardCode() {
		return paymentCardCode;
	}
	public void setPaymentCardCode(String paymentCardCode) {
		this.paymentCardCode = paymentCardCode;
	}
	public String getPaymentCvv() {
		return paymentCvv;
	}
	public void setPaymentCvv(String paymentCvv) {
		this.paymentCvv = paymentCvv;
	}
	public String getPaymentName() {
		return paymentName;
	}
	public void setPaymentName(String paymentName) {
		this.paymentName = paymentName;
	}
	public String getPaymentSurname() {
		return paymentSurname;
	}
	public void setPaymentSurname(String paymentSurname) {
		this.paymentSurname = paymentSurname;
	}
	public Date getPaymentCardExpiration() {
		return paymentCardExpiration;
	}
	public void setPaymentCardExpiration(Date paymentCardExpiration) {
		this.paymentCardExpiration = paymentCardExpiration;
	}
	public String getPaymentEmail() {
		return paymentEmail;
	}
	public void setPaymentEmail(String paymentEmail) {
		this.paymentEmail = paymentEmail;
	}
	public String getTransactionAddress() {
		return transactionAddress;
	}
	public void setTransactionAddress(String transactionAddress) {
		this.transactionAddress = transactionAddress;
	}
	public String getTransactionPhone() {
		return transactionPhone;
	}
	public void setTransactionPhone(String transactionPhone) {
		this.transactionPhone = transactionPhone;
	}
	public String getTransactionEmail() {
		return transactionEmail;
	}
	public void setTransactionEmail(String transactionEmail) {
		this.transactionEmail = transactionEmail;
	}

}
