package com.gamesgo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamesgo.dto.GameSalesDTO;
import com.gamesgo.model.Game;
import com.gamesgo.repository.GameRepository;
import com.gamesgo.repository.TransactionRepository;

@Service
public class GameSalesService {
	
	@Autowired
	private GameRepository gameRepository;
		
    @Autowired
    private TransactionRepository transactionRepository;

    public List<Game> getGameSales() {
        List<Object[]> results = transactionRepository.getList();
        List<Game> gameList = new ArrayList<>();
        for (Object[] result : results) {
        	gameList.add(gameRepository.findById(((Number) result[0]).intValue()).orElse(new Game()));
        }
        return gameList;
    }
}

