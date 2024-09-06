package com.gamesgo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gamesgo.model.Game;
import com.gamesgo.repository.GameRepository;
import com.gamesgo.repository.GenreRepository;

@Controller
public class CatalogController {
	@Autowired
	private GameRepository gameRep;
	@Autowired
	private GenreRepository genRep;

	final private static String catalogPath = "home/catalog.jsp";

	@GetMapping("/catalog")
	public String catalog(Model model) {
		getDefaultCatalog(model);	
		return catalogPath;
	}

	@PostMapping("/catalog")
	public String catalogFilter(@RequestParam String opType, @RequestParam String input, Model model) {
		
		if (opType == null) {
			model.addAttribute("show", "show");
			model.addAttribute("message", "Operazione nulla");
			model.addAttribute("color", "red");
			model.addAttribute("title", "Errore!");
			getDefaultCatalog(model);

			return catalogPath;
		}
		
		if(input == null) {
			model.addAttribute("show", "show");
			model.addAttribute("message", "Input nullo");
			model.addAttribute("color", "red");
			model.addAttribute("title", "Errore!");
			getDefaultCatalog(model);

			return catalogPath;
		}

		switch (opType) {
		case "titleAndAuthor":
			List<Game> games = gameRep.findByAuthorOrName(input);
			if (games==null) {
				model.addAttribute("show", "show");
				model.addAttribute("message", "Non abbiamo trovato nulla per "+input+".");
				model.addAttribute("color", "yellow");
				model.addAttribute("title", "Warning!");
			}
			
			model.addAttribute("input",input);
			model.addAttribute("games", games);
			getGenres(model);

			break;
		default:
			model.addAttribute("show", "show");
			model.addAttribute("message", "Operazione non riconosciuta");
			model.addAttribute("color", "red");
			model.addAttribute("title", "Errore!");
			getDefaultCatalog(model);

			break;
		}
		
		return catalogPath;
	}

	public void getDefaultCatalog(Model model) {
		model.addAttribute("games", gameRep.findAll());
		getGenres(model);
	}
	
	public void getGenres(Model model) {
		model.addAttribute("genres", genRep.findAll());
	}
}
