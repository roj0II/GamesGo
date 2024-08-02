package com.gamesgo.dto;

import java.sql.Date;

public class ShippingDto {
	private int id;
	private Date shippingDate;
	private Date scheduleDeliveryDate;
	private String status;
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
