package com.gamesgo.dto;

import com.gamesgo.model.Transaction;

public class TransactionDto {
	private int id;
	private int idUser;
	private int idGame;
	private Transaction transaction;
	
	public Transaction getTransaction() {
		return transaction;
	}
	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}
	public int getId() {
		return id;
	}
	public int getIdUser() {
		return idUser;
	}
	public int getIdGame() {
		return idGame;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public void setIdGame(int idGame) {
		this.idGame = idGame;
	}
		
}
