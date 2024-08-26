package com.gamesgo.dto;

import java.sql.Date;

import com.gamesgo.model.Transaction;
import com.gamesgo.model.User;

public class ShippingDto {
	private int id;
	private Date shippingDate;
	private Date scheduleDeliveryDate;
	private String status;
	private User user;
	private Transaction transaction;

	public Transaction getTransaction() {
		return transaction;
	}
	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getShippingDate() {
		return shippingDate;
	}
	public void setShippingDate(Date shippingDate) {
		this.shippingDate = shippingDate;
	}
	public Date getScheduleDeliveryDate() {
		return scheduleDeliveryDate;
	}
	public void setScheduleDeliveryDate(Date scheduleDeliveryDate) {
		this.scheduleDeliveryDate = scheduleDeliveryDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
