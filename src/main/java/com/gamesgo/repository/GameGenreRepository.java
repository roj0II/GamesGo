package com.gamesgo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.gamesgo.model.Game;
import com.gamesgo.model.Gamegenre;
import com.gamesgo.model.Genre;

public interface GameGenreRepository extends JpaRepository<Gamegenre, Integer> {

	 @Query(value = "SELECT g.id FROM genre g INNER JOIN gamegenre gg ON g.id = gg.id_genre GROUP BY g.id ORDER BY COUNT(gg.id) DESC LIMIT 5", nativeQuery = true)
	    List<Integer> findTopGenreIds();

	 @Query(value = "SELECT * FROM gamegenre WHERE id_genre = :genreId LIMIT 1;", nativeQuery = true)
	    Gamegenre findFirstByGenreId(@Param("genreId") int genreId);

	public Gamegenre findByGameAndGenre(Game game, Genre genre);
}