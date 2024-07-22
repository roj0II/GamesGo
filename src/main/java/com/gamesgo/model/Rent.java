package com.gamesgo.model;

import java.sql.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Rent {

	@Id
	private int id;
	@ManyToOne
	@JoinColumn(name = "idTransaction")
	private Transaction transaction;
	private Date startDate;
	private Date endDate;

}
