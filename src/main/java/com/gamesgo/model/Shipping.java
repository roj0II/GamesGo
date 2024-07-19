package com.gamesgo.model;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Shipping implements Serializable {
	@Id
	private int id;
	@ManyToOne
	@JoinColumn(name="idTransaction")
	private Transaction transaction;
	@ManyToOne
	@JoinColumn(name="idUser")
	private User user;
	Date shippingDate;
	Date scheduleDeliveryDate;
	private String status;
	
}
