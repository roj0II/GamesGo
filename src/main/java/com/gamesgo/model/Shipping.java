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
	private int idTransaction;
	@ManyToOne
	@JoinColumn(name="idUser")
	private int idUser;
	Date shippingDate;
	Date scheduleDeliveryDate;
	private String status;
	
}
