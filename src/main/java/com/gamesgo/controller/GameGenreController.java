package com.gamesgo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.gamesgo.dto.GameGenreDto;
import com.gamesgo.interfaces.CrudControllerI;
import com.gamesgo.repository.GameGenreRepository;

@Controller
@RequestMapping("gameGenre")
public class GameGenreController implements CrudControllerI<GameGenreDto> {

	@GetMapping("/")
	public String main(Model model) {
		return "gameGenre.jsp";
	}

	@Autowired
	private GameGenreRepository gameGenreRep;
	
	@GetMapping("preInsert")
	public String preInsert(Model model) {
		GameGenreDto gameGenreDto = new GameGenreDto();
		model.addAttribute("genreForm", gameGenreDto);
		return "insertGameGenre.jsp";
	}

	@Override
	public String insert(Model model, GameGenreDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String preUpdate(Model model, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(Model model, GameGenreDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(Model model, int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
