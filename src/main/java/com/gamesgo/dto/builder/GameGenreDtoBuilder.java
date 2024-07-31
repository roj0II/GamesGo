package com.gamesgo.dto.builder;

import org.springframework.beans.factory.annotation.Autowired;
import com.gamesgo.dto.GameGenreDto;
import com.gamesgo.model.Game;
import com.gamesgo.model.Gamegenre;
import com.gamesgo.model.Genre;
import com.gamesgo.repository.GameRepository;
import com.gamesgo.repository.GenreRepository;

public class GameGenreDtoBuilder {
	@Autowired
	private static GameRepository gameRep;
	@Autowired
	private static GenreRepository genreRep;
	
	public static Gamegenre fromDtoToEntity (GameGenreDto gameGenreDto) {
		Gamegenre gameGenre = new Gamegenre();
		gameGenre.setId(gameGenreDto.getId());
		Game game = gameRep.findById(gameGenreDto.getIdGame()).orElse(new Game());
		gameGenre.setGame(game);
		Genre genre = genreRep.findById(gameGenreDto.getIdGenre()).orElse(new Genre());
		gameGenre.setGenre(genre);
		
		return gameGenre;
	}
	
	public static GameGenreDto fromEntityToDto (Gamegenre gameGenre) {
		GameGenreDto gameGenreDto = new GameGenreDto();
		gameGenreDto.setId(gameGenre.getId());
		gameGenreDto.setIdGame(gameGenre.getGame().getId());
		gameGenreDto.setIdGenre(gameGenre.getGenre().getId());
		
		return gameGenreDto;
	}
}
