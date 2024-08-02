package com.gamesgo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.gamesgo.dto.GameGenreDto;
import com.gamesgo.dto.builder.GameGenreDtoBuilder;
import com.gamesgo.interfaces.CrudControllerI;
import com.gamesgo.model.Gamegenre;
import com.gamesgo.repository.GameGenreRepository;

@Controller
@RequestMapping("gamegenre")
public class GameGenreController implements CrudControllerI<GameGenreDto> {
	@Autowired
	private GameGenreRepository gameGenreRep;

	@GetMapping("/")
	public String main(Model model) {
		model.addAttribute("gameGenreList", gameGenreRep.findAll());
		return "gameGenre.jsp";
	}

	@GetMapping("insert")
	public String preInsert(Model model) {
		GameGenreDto gameGenreDto = new GameGenreDto();
		model.addAttribute("gameGenreForm", gameGenreDto);
		return "insertGameGenre.jsp";
	}

	@PostMapping("insert")
	public String insert(Model model, @ModelAttribute("gameGenreForm") GameGenreDto dto) {
		try {
			gameGenreRep.save(GameGenreDtoBuilder.fromDtoToEntity(dto));
		} catch (DataIntegrityViolationException e) {
			model.addAttribute("gameGenreForm", dto);
			return "insertGameGenre.jsp";
		}
		return "redirect:/gamegenre/";
	}

	@GetMapping("update/{id}")
	public String preUpdate(Model model, @PathVariable int id) {
		Gamegenre gameG = gameGenreRep.findById(id).orElse(new Gamegenre());
		model.addAttribute("gameGenreForm", GameGenreDtoBuilder.fromEntityToDto(gameG));
		return "/gamegenre/editGameGenre.jsp";
	}

	@PostMapping("update")
	public String update(Model model, @ModelAttribute("gameGenreForm") GameGenreDto dto) {
		try {
			gameGenreRep.save(GameGenreDtoBuilder.fromDtoToEntity(dto));
		} catch (JpaObjectRetrievalFailureException e) {
			model.addAttribute("gameGenreForm", dto);
			return "/gamegenre/editGameGenre.jsp";
		}
		return "redirect:/gamegenre/";
	}

	@GetMapping("delete/{id}")
	public String delete(Model model, @PathVariable int id) {
		gameGenreRep.deleteById(id);
		return "redirect:/gamegenre/";
	}
}
