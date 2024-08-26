package com.gamesgo.dto;

import java.sql.Date;

import com.gamesgo.model.Transaction;

public class RentDto {
	

	
	private int id;
	private Transaction transaction;
	private Date startDate;
	private Date endDate;
	private String type;
	private String productKey;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Transaction getTransaction() {
		return transaction;
	}
	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getProductKey() {
		return productKey;
	}
	public void setProductKey(String productKey) {
		this.productKey = productKey;
	}

}
