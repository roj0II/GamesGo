package com.gamesgo.dto.builder;

import com.gamesgo.dto.GameDto;
import com.gamesgo.model.Game;

public class GameDtoBuilder {
	public static Game fromDtoToEntity(GameDto gameDto) {
		Game game=new Game();
		game.setAuthor(gameDto.getAuthor());
		game.setDescription(gameDto.getDescription());
		game.setId(gameDto.getId());
		game.setTitle(gameDto.getTitle());
		game.setReleaseDate(gameDto.getReleaseDate());
		game.setPhotoUrl(gameDto.getPhotoUrl());
		game.setPriceDigital(gameDto.getPriceDigital());
		game.setPriceRetail(gameDto.getPriceRetail());
		return game;
		
	}
	public static GameDto fromEntityToDto(Game game) {
		GameDto gameDto=new GameDto();
		gameDto.setAuthor(game.getAuthor());
		gameDto.setDescription(game.getDescription());
		gameDto.setId(game.getId());
		gameDto.setTitle(game.getTitle());
		gameDto.setReleaseDate(game.getReleaseDate());
		gameDto.setPhotoUrl(game.getPhotoUrl());
		gameDto.setPriceDigital(game.getPriceDigital());
		gameDto.setPriceRetail(game.getPriceRetail());
		return gameDto;
		
		
	}
}
