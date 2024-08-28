package com.gamesgo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.gamesgo.repository.GameRepository;
import com.gamesgo.repository.GenreRepository;

@Controller
public class CatalogController {
	@Autowired
	private GameRepository gameRep;
	@Autowired
	private GenreRepository genRep;

	final private static String catalogPath = "home/shop.jsp";

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
		case "":
			break;
		case "ciao":
			break;
		case "ciaone":
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
		model.addAttribute("genres", genRep.findAll());
	}
}
