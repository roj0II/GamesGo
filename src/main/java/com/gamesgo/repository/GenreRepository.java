package com.gamesgo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gamesgo.model.Genre;

public interface GenreRepository extends JpaRepository<Genre, Integer> {
	
	public Genre findByName(String name);
	
}
