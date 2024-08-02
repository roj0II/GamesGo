package com.gamesgo.dto;

public class StorageDto {
	private int id;
	private int idGame;
	private int amountRetail;
	private int amountDigital;

	public int getId() {
		return id;
	}

	public int getIdGame() {
		return idGame;
	}

	public int getAmountRetail() {
		return amountRetail;
	}

	public int getAmountDigital() {
		return amountDigital;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setIdGame(int idGame) {
		this.idGame = idGame;
	}

	public void setAmountRetail(int amountRetail) {
		this.amountRetail = amountRetail;
	}

	public void setAmountDigital(int amountDigital) {
		this.amountDigital = amountDigital;
	}

}
