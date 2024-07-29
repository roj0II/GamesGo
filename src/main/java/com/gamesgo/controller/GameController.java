package com.gamesgo.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gamesgo.dto.GameDto;
import com.gamesgo.dto.builder.GameDtoBuilder;
import com.gamesgo.model.Game;
import com.gamesgo.repository.GameRepository;

import jakarta.persistence.EntityManager;

@Controller
@RequestMapping("/game")
public class GameController {
	private EntityManager em;
	@Autowired
	GameRepository gameRep;

	@GetMapping("/insert")
	public String preinsert(Model model) {
		GameDto gameDto = new GameDto();
		model.addAttribute("gameForm", gameDto);
		return "/game/insertGame.jsp";

	}

	@PostMapping("/insert")
	public String insert(Model model, @ModelAttribute("gameForm") GameDto gameDto) {
		Game game = GameDtoBuilder.fromDtoToEntity(gameDto);
		gameRep.save(game);
		return "/game/game.jsp";
	}

	@GetMapping("/show")
	public String showList(Model model) {
		ArrayList<GameDto> gameListDto = new ArrayList<>();
		ArrayList<Game> gameList = new ArrayList<>();
		for (GameDto g : gameListDto) {
			gameList.add(GameDtoBuilder.fromDtoToEntity(g));
			
		}
		model.addAttribute("gameListForm", gameList);
		return "/game/showGame.jsp";
	}
	@DeleteMapping("/delete/{id}")
	public String elimina(@PathVariable int id){
	this.gameRep.deleteById(id);

	return "ok";
	}
	@GetMapping("/edit/{id}")
	public String preEdit(@PathVariable int id, Model model) {
		Game game=gameRep.findById(id).orElse(new Game());
		model.addAttribute("Gameform",game);
		return "/game/editGame.jsp";
	}
	@PostMapping("/edit")
	public String edit(@ModelAttribute("gameForm") Game game) {
		gameRep.save(game);
		return "game.jsp";
	}
}