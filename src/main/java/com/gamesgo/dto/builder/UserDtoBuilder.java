package com.gamesgo.dto.builder;

import com.gamesgo.dto.UserDto;
import com.gamesgo.model.User;

public class UserDtoBuilder {
	public static User fromDtoToEntity(UserDto dto) {
		User user = new User();
		user.setId(dto.getId());
		user.setUsername(dto.getUsername());
		user.setName(dto.getName());
		user.setSurname(dto.getSurname());
		user.setAddress(dto.getAddress());
		user.setPhone(dto.getPhone());
		user.setEmail(dto.getEmail());
		user.setPassword(dto.getPassword());
		user.setAdmin(dto.isAdmin());

		return user;
	}

	public static UserDto fromEntityToDto(User user) {
		UserDto dtu = new UserDto();
		dtu.setId(user.getId());
		dtu.setUsername(user.getUsername());
		dtu.setName(user.getName());
		dtu.setSurname(user.getSurname());
		dtu.setAddress(user.getAddress());
		dtu.setPhone(user.getAddress());
		dtu.setEmail(user.getEmail());
		dtu.setPassword(user.getPassword());
		dtu.setAdmin(user.isAdmin());

		return dtu;
	}
}
