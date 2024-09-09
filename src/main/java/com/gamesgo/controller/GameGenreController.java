package com.gamesgo.controller;

import java.util.Comparator;

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
import com.gamesgo.model.Game;
import com.gamesgo.model.Gamegenre;
import com.gamesgo.model.Genre;
import com.gamesgo.model.User;
import com.gamesgo.repository.GameGenreRepository;
import com.gamesgo.repository.GameRepository;
import com.gamesgo.repository.GenreRepository;
import com.gamesgo.util.AdminManager;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("gamegenre")
public class GameGenreController implements CrudControllerI<GameGenreDto> {
	@Autowired
	private GameGenreRepository gameGenreRep;

	@Autowired
	private GameRepository gameRep;
	
	@Autowired
	private GenreRepository genreRep;
	
	@GetMapping("/")
	public String main(Model model, HttpSession session) {
		User loggedUser = (User) session.getAttribute("loggedUser");

		model.addAttribute("gameGenreList", gameGenreRep.findAll());
        return AdminManager.checkAdmin(loggedUser,"gameGenre.jsp");
	}

	@GetMapping("insert")
	public String preInsert(Model model, HttpSession session) {
		User loggedUser = (User) session.getAttribute("loggedUser");

		GameGenreDto gameGenreDto = new GameGenreDto();
		setGameGenre(model);
		model.addAttribute("gameGenreForm", gameGenreDto);
        return AdminManager.checkAdmin(loggedUser,"insertGameGenre.jsp");

	}

	@PostMapping("insert")
	public String insert(Model model, HttpSession session, @ModelAttribute("gameGenreForm") GameGenreDto dto) {		
		// Controllo sui dati inseriti
		Game game = new Game();
		game.setId(dto.getIdGame());
		Genre genre = new Genre();
		genre.setId(dto.getIdGenre());
		Gamegenre gG = gameGenreRep.findByGameAndGenre(game, genre);
		if(gG != null) {
			model.addAttribute("gameGenreForm", dto);
			
			model.addAttribute("error", true);
			model.addAttribute("message", "Associazione già presente nel DB");
			model.addAttribute("color", "red");
			model.addAttribute("title", "Error!");
			
			setGameGenre(model);
			
			return "insertGameGenre.jsp";
		}
		
		// Tentativo di salvataggio sul database
		try {
			gameGenreRep.save(GameGenreDtoBuilder.fromDtoToEntity(dto));
		} catch (DataIntegrityViolationException e) {
			model.addAttribute("gameGenreForm", dto);
			return "insertGameGenre.jsp";
		}
		return "redirect:/gamegenre/";
	}

	@GetMapping("update/{id}")
	public String preUpdate(Model model, HttpSession session, @PathVariable int id) {
		User loggedUser = (User) session.getAttribute("loggedUser");

		Gamegenre gameG = gameGenreRep.findById(id).orElse(new Gamegenre());
		model.addAttribute("games",gameRep.findAll().stream()
	            .sorted(Comparator.comparing(Game::getTitle))
	            .toList()); // Lista Giochi
		model.addAttribute("genres",genreRep.findAll().stream()
	            .sorted(Comparator.comparing(Genre::getName))
	            .toList()); // Lista Genre
		model.addAttribute("gameGenreForm", GameGenreDtoBuilder.fromEntityToDto(gameG));
        return AdminManager.checkAdmin(loggedUser,"/gamegenre/editGameGenre.jsp");
}

	@PostMapping("update")
	public String update(Model model, HttpSession session, @ModelAttribute("gameGenreForm") GameGenreDto dto) {
		// Controllo sui dati inseriti
		Game game = new Game();
		game.setId(dto.getIdGame());
		Genre genre = new Genre();
		genre.setId(dto.getIdGenre());
		Gamegenre gG = gameGenreRep.findByGameAndGenre(game, genre);
		if(gG != null) {
			model.addAttribute("gameGenreForm", dto);
					
			model.addAttribute("error", true);
			model.addAttribute("message", "Associazione già presente nel DB");
			model.addAttribute("color", "red");
			model.addAttribute("title", "Error!");
					
			setGameGenre(model);
					
			return "/gamegenre/editGameGenre.jsp";
		}
		
		// Tentativo di aggiornamento nel database		
		try {
			gameGenreRep.save(GameGenreDtoBuilder.fromDtoToEntity(dto));
		} catch (JpaObjectRetrievalFailureException e) {
			model.addAttribute("gameGenreForm", dto);
			return "/gamegenre/editGameGenre.jsp";
		}
		return "redirect:/gamegenre/";
	}

	@GetMapping("delete/{id}")
	public String delete(Model model, HttpSession session, @PathVariable int id) {
		gameGenreRep.deleteById(id);
		return "redirect:/gamegenre/";
	}
	
	public void setGameGenre(Model model) {
		model.addAttribute("games",gameRep.findAll().stream()
	            .sorted(Comparator.comparing(Game::getTitle))
	            .toList()); // Lista di giochi
		model.addAttribute("genres",genreRep.findAll().stream()
	            .sorted(Comparator.comparing(Genre::getName))
	            .toList()); // Lista di Generi
	}
}
