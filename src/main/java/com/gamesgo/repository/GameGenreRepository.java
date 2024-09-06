package com.gamesgo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.gamesgo.model.Gamegenre;

public interface GameGenreRepository extends JpaRepository<Gamegenre, Integer> {

}
