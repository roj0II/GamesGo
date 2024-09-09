package com.gamesgo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gamesgo.model.Game;
import com.gamesgo.model.Gamegenre;
import com.gamesgo.model.Genre;

public interface GameGenreRepository extends JpaRepository<Gamegenre, Integer> {
	public Gamegenre findByGameAndGenre(Game game, Genre genre);
}
