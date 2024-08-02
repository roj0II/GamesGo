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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gamesgo.dto.GameDto;
import com.gamesgo.dto.builder.GameDtoBuilder;
import com.gamesgo.interfaces.CrudControllerI;
import com.gamesgo.model.Game;
import com.gamesgo.repository.GameRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Controller
@RequestMapping("/game")
public class GameController implements CrudControllerI<GameDto>{
	
	@Autowired
	GameRepository gameRep;
	@PersistenceContext
	private EntityManager entityManager;
	@GetMapping("/")
	public String main(Model model) {
		ArrayList<GameDto> gameListDto = new ArrayList<>();
		ArrayList<Game> gameList = new ArrayList<>();
        TypedQuery<Game> query = entityManager.createQuery("SELECT g FROM Game g", Game.class);
        gameList=(ArrayList<Game>)query.getResultList();
		
		
		 
		model.addAttribute("gameListForm", gameList);
		
		return "game.jsp";
	}
	@GetMapping("/insert")
	public String preInsert(Model model) {
		GameDto gameDto = new GameDto();
		model.addAttribute("gameForm", gameDto);
		return "/game/insertGame.jsp";

	}

	@PostMapping("/insert")
	public String insert(Model model, @ModelAttribute("gameForm") GameDto gameDto) {
		Game game = GameDtoBuilder.fromDtoToEntity(gameDto);
		gameRep.save(game);
		return "redirect:/game/";
	}


	@GetMapping("/delete/{id}")
	public String delete(Model model,@PathVariable int id){
	this.gameRep.deleteById(id);
	
	return "redirect:/game/";
	}
	@GetMapping("/update/{id}")
	public String preUpdate(Model model, @PathVariable int id) {
		Game game=gameRep.findById(id).orElse(new Game());
		GameDto gameDto=GameDtoBuilder.fromEntityToDto(game);
		model.addAttribute("gameForm",gameDto);
		return "/game/editGame.jsp";
	}
	@PostMapping("/update")
	public String update(Model model, @ModelAttribute("gameForm") GameDto gameDto) {
		Game game=GameDtoBuilder.fromDtoToEntity(gameDto);
		gameRep.save(game);
		
		return "redirect:/game/";
	}
	

	


	

	

	
}