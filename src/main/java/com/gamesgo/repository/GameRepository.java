
package com.gamesgo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gamesgo.model.Game;

public interface GameRepository extends JpaRepository<Game, Integer> {
	public Game findByTitle(String title);
	public List<Game> findByAuthorContaining(String author);
	public List<Game> findByTitleContaining(String title);
	 @Query("SELECT g FROM Game g WHERE g.author LIKE %:input% OR g.title LIKE %:input%")
	    List<Game> findByAuthorOrName(@Param("input") String input);	 
	 @Query(value = "SELECT * FROM game ORDER BY RAND() LIMIT 1", nativeQuery = true)
	 public Game findRandomGame();
}
