package com.gamesgo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gamesgo.model.Rent;

public interface RentRepository extends JpaRepository<Rent,Integer> {
public Rent findByProductKey(String key);
}
