package com.gamesgo.model;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Shipping implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	@ManyToOne
	@JoinColumn(name="idTransaction")
	private Transaction transaction;
	@ManyToOne
	@JoinColumn(name="idUser")
	private User user;
	private Date shippingDate;
	private Date scheduleDeliveryDate;
	private String status;
	
}
