package com.gamesgo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gamesgo.model.Gamegenre;

public interface GameGenreRepository extends JpaRepository<Gamegenre, Integer> {

}
