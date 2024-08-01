package com.gamesgo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gamesgo.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

}
