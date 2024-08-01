package com.gamesgo.dto.builder;

import com.gamesgo.dto.StorageDto;
import com.gamesgo.model.Game;
import com.gamesgo.model.Storage;

public class StorageDtoBuilder {
	public static Storage fromDtoToEntity(StorageDto dto) {
		Storage storage = new Storage();
		storage.setId(dto.getId());
		Game g = new Game();
		g.setId(dto.getIdGame());
		storage.setGame(g);
		storage.setAmountRetail(dto.getAmountRetail());
		storage.setAmountDigital(dto.getAmountDigital());		

		return storage;
	}

	public static StorageDto fromEntityToDto(Storage s) {
		StorageDto dtStorage = new StorageDto();
		dtStorage.setId(s.getId());
		dtStorage.setIdGame(s.getGame().getId());
		dtStorage.setAmountRetail(s.getAmountRetail());
		dtStorage.setAmountDigital(s.getAmountDigital());
		
		return dtStorage;
	}
}
