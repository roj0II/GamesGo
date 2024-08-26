package com.gamesgo.dto.builder;

import com.gamesgo.dto.ShippingDto;
import com.gamesgo.model.Shipping;

public class ShippingDtoBuilder {
	public static Shipping fromDtoToEntity(ShippingDto shippingDto) {
		Shipping shipping=new Shipping();
		shipping.setId(shippingDto.getId());
		shipping.setScheduleDeliveryDate(shippingDto.getScheduleDeliveryDate());
		shipping.setShippingDate(shippingDto.getShippingDate());
		shipping.setStatus(shippingDto.getStatus());
		shipping.setUser(shippingDto.getUser());
		shipping.setTransaction(shippingDto.getTransaction());
		return shipping;
	}
	public static ShippingDto fromEntityToDto(Shipping shipping) {
		ShippingDto shippingDto=new ShippingDto();
		shippingDto.setId(shipping.getId());
		shippingDto.setScheduleDeliveryDate(shipping.getScheduleDeliveryDate());
		shippingDto.setShippingDate(shipping.getShippingDate());
		shippingDto.setStatus(shipping.getStatus());
		shippingDto.setUser(shipping.getUser());
		shippingDto.setTransaction(shipping.getTransaction());
		return shippingDto;
	}
}
