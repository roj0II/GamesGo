package com.gamesgo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamesgo.dto.GameSalesDTO;
import com.gamesgo.repository.TransactionRepository;

@Service
public class GameSalesService {
	

		
	    @Autowired
	    private TransactionRepository transactionRepository;

	    public List<GameSalesDTO> getGameSales() {
	        List<Object[]> results = transactionRepository.getList();
	        List<GameSalesDTO> gameSalesList = new ArrayList<>();

	        for (Object[] result : results) {
	            Long gameId = ((Number) result[0]).longValue(); 
	            Long sales = ((Number) result[1]).longValue();   

	            gameSalesList.add(new GameSalesDTO(gameId, sales));
	        }

	        return gameSalesList;
	    }
	}

