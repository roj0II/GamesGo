package com.gamesgo.dto.builder;

import com.gamesgo.dto.RentDto;
import com.gamesgo.model.Rent;

public class RentDtoBuilder {
	public  static Rent fromDtoToEntity(RentDto rentDto) {
		Rent rent =new Rent();
		rent.setId(rentDto.getId());
		rent.setStartDate(rentDto.getStartDate());
		rent.setEndDate(rentDto.getEndDate());
		rent.setProductKey(rentDto.getProductKey());
		rent.setTransaction(rentDto.getTransaction());;
		rent.setType(rentDto.getType());
		rent.setTransaction(rentDto.getTransaction());
		return rent;
	}
	public static RentDto fromEntityToDto(Rent rent) {
		
		RentDto rentDto=new RentDto();
		rentDto.setTransaction(rent.getTransaction());
		rentDto.setId(rent.getId());
		rentDto.setStartDate(rent.getStartDate());
		rentDto.setEndDate(rent.getEndDate());
		rentDto.setProductKey(rent.getProductKey());
		rentDto.setTransaction(rent.getTransaction());
		rentDto.setType(rent.getType());
		return rentDto;
	}
}
