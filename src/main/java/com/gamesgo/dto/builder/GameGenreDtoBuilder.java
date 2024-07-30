package com.gamesgo.dto.builder;

import com.gamesgo.dto.GameGenreDto;
import com.gamesgo.model.Game;
import com.gamesgo.model.Gamegenre;
import com.gamesgo.model.Genre;

public class GameGenreDtoBuilder {

	public static Gamegenre fromDtoToEntity(GameGenreDto gameGenreDto) {
		Gamegenre gameGenre = new Gamegenre();
		gameGenre.setId(gameGenreDto.getId());
		Game game = new Game();
		game.setId(gameGenreDto.getId());
		gameGenre.setGame(game);
		Genre genre = new Genre();
		genre.setId(gameGenreDto.getIdGenre());
		gameGenre.setGenre(genre);

		return gameGenre;
	}

	public static GameGenreDto fromEntityToDto(Gamegenre gameGenre) {
		GameGenreDto gameGenreDto = new GameGenreDto();
		gameGenreDto.setId(gameGenre.getId());
		gameGenreDto.setIdGame(gameGenre.getGame().getId());
		gameGenreDto.setIdGenre(gameGenre.getGenre().getId());

		return gameGenreDto;
	}
}
