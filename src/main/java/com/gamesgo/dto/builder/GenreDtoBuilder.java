package com.gamesgo.dto.builder;

import com.gamesgo.dto.GenreDto;
import com.gamesgo.model.Genre;

public class GenreDtoBuilder {
	
	public static Genre fromDtoToEntity (GenreDto genreDto) {
		Genre genre = new Genre();
		genre.setId(genreDto.getId());
		genre.setName(genreDto.getName());
		return genre;
	}
	
	public static GenreDto fromEntityToDto (Genre genre) {
		GenreDto genreDto = new GenreDto();
		genreDto.setId(genre.getId());
		genreDto.setName(genre.getName());
		return genreDto;
	}
	
}
