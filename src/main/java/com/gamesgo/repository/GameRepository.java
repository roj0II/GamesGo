
package com.gamesgo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gamesgo.model.Game;

public interface GameRepository extends JpaRepository<Game, Integer> {
	public Game findByTitle(String title);
}
