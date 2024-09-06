package com.gamesgo.dto;

public class GameSalesDTO {
    private Long gameId;
    private Long sales;

    public GameSalesDTO(Long gameId, Long sales) {
        this.gameId = gameId;
        this.sales = sales;
    }

    // Getter e setter
    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public Long getSales() {
        return sales;
    }

    public void setSales(Long sales) {
        this.sales = sales;
    }

	@Override
	public String toString() {
		return "GameSalesDTO [gameId=" + gameId + ", sales=" + sales + "]";
	}
}
