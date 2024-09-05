package com.gamesgo.dto.builder;

import com.gamesgo.dto.TransactionDto;
import com.gamesgo.model.Game;
import com.gamesgo.model.Transaction;
import com.gamesgo.model.User;

public class TransactionDtoBuilder {

	public static Transaction fromDtoToEntity(TransactionDto dto) {
		Transaction transaction = new Transaction();
		transaction.setId(dto.getId());
		User u = new User();
		u.setId(dto.getIdUser());
		transaction.setUser(u);
		Game g = new Game();
		g.setId(dto.getIdGame());
		transaction.setGame(g);
		transaction.setCheckoutPayment(dto.getCheckoutPayment());

		return transaction;
	}

	public static TransactionDto fromEntityToDto(Transaction transaction) {
		TransactionDto transDto = new TransactionDto();
		transDto.setId(transaction.getId());
		transDto.setIdUser(transaction.getUser().getId());
		transDto.setIdGame(transaction.getGame().getId());
		transDto.setCheckoutPayment(transaction.getCheckoutPayment());
		return transDto;
	}
}
