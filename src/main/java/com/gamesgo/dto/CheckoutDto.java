package com.gamesgo.dto;

import java.util.Date;

public class CheckoutDto {

	// Dati per sapere se è online o fisico | compra o affitta
	private boolean online;
	private boolean rent; 
	
	// Dati utente, Ottenuti dal loggedUser.
	private String userAddress;
	private String userEmail;
	private String userPhone;
	private String userName;
	private String userSurname;
	// private boolean admin; se vogliamo, facciamo che all'admin si applica 20% di sconto automaticamente.EXTRA
	
	// Dati gioco, Ottenuti dal gioco selezionato per l'acquisto/affitto.
	private int gameId;
	private String gameTitle;
	private float gamePrice; // in base alla scelta dell'utente verrà usato quello retail o digital.
	private String gamePhotoUrl;
	
	// Dati consegna - fisico
	private String shippingName;
	private String shippingSurname;
	private String shippingEmail;
	private String shippingPhone;
	private String shippingAddress; // se compriamo fisicamente, servirà anche questo campo.
	private String shippingMethod; // picklist che aumenterà il prezzo in base alla scelta.
	private String shippingNotes; // le classiche note da dare a chi consegna. (piano n21)
	private Date shippingOrderDate;
	private Date shippingScheduleDate;
	
	// Dati affitto
	private int rentDays;
	private Date rentFinishDate;
	
	// Dati pagamento con carta:
	private String paymentCardCode;
	private String paymentCvv;
	private String paymentNameAndSurname;
	private String paymentCardExpiration;
	
	
	// Dati fatturazione:
	private String transactionName;
	private String transactionSurname;
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
	public boolean isRent() {
		return rent;
	}
	public void setRent(boolean rent) {
		this.rent = rent;
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
	public String getPaymentCardExpiration() {
		return paymentCardExpiration;
	}
	public void setPaymentCardExpiration(String paymentCardExpiration) {
		this.paymentCardExpiration = paymentCardExpiration;
	}
	public String getShippingName() {
		return shippingName;
	}
	public void setShippingName(String shippingName) {
		this.shippingName = shippingName;
	}
	public String getShippingSurname() {
		return shippingSurname;
	}
	public void setShippingSurname(String shippingSurname) {
		this.shippingSurname = shippingSurname;
	}
	public String getShippingNotes() {
		return shippingNotes;
	}
	public void setShippingNotes(String shippingNotes) {
		this.shippingNotes = shippingNotes;
	}
	public String getShippingMethod() {
		return shippingMethod;
	}
	public void setShippingMethod(String shippingMethod) {
		this.shippingMethod = shippingMethod;
	}
	public Date getRentFinishDate() {
		return rentFinishDate;
	}
	public void setRentFinishDate(Date rentFinishDate) {
		this.rentFinishDate = rentFinishDate;
	}
	public String getTransactionName() {
		return transactionName;
	}
	public void setTransactionName(String transactionName) {
		this.transactionName = transactionName;
	}
	public String getTransactionSurname() {
		return transactionSurname;
	}
	public void setTransactionSurname(String transactionSurname) {
		this.transactionSurname = transactionSurname;
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
	public String getPaymentNameAndSurname() {
		return paymentNameAndSurname;
	}
	public void setPaymentNameAndSurname(String paymentNameAndSurname) {
		this.paymentNameAndSurname = paymentNameAndSurname;
	}
	public int getGameId() {
		return gameId;
	}
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
	public Date getShippingOrderDate() {
		return shippingOrderDate;
	}
	public void setShippingOrderDate(Date shippingOrderDate) {
		this.shippingOrderDate = shippingOrderDate;
	}
	public Date getShippingScheduleDate() {
		return shippingScheduleDate;
	}
	public void setShippingScheduleDate(Date shippingScheduleDate) {
		this.shippingScheduleDate = shippingScheduleDate;
	}

}
