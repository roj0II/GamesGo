package com.gamesgo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gamesgo.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
	

			@Query(value = "SELECT t.id_game, COUNT(*) as sales " +
	                   "FROM transaction t " +
	                   "GROUP BY t.id_game " +
	                   "ORDER BY sales DESC " +
	                   "LIMIT 6", 
	           nativeQuery = true)
	public List<Object[]> getList();
}
