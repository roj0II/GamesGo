package com.gamesgo.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Shipping implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name = "idTransaction")
	private Transaction transaction;
	@ManyToOne
	@JoinColumn(name = "idUser")
	private User user;
	@Column(nullable=false)
	private Date shippingDate;
	@Column(nullable=false)
	private Date scheduleDeliveryDate;
	@Column(nullable=false)
	private String status;

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getShippingDate() {
		return shippingDate;
	}

	public void setShippingDate(Date date) {
		this.shippingDate = date;
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
