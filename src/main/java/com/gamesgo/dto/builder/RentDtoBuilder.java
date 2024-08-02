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
		
		rent.setType(rentDto.getType());
		return rent;
	}
	public static RentDto fromEntityToDto(Rent rent) {
		RentDto rentDto=new RentDto();
		rentDto.setId(rent.getId());
		rentDto.setStartDate(rent.getStartDate());
		rentDto.setEndDate(rent.getEndDate());
		rentDto.setProductKey(rent.getProductKey());
		
		rentDto.setType(rent.getType());
		return rentDto;
	}
}
