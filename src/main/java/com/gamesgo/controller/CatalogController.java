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

	final private String catalogPath = "catalog.jsp";

	@GetMapping("/catalog")
	public String catalog(Model model) {
		model.addAttribute("games", gameRep.findAll());
		return catalogPath;
	}

	@PostMapping("/catalog")
	public String catalogFilter(@RequestParam String opType, @RequestParam String input, Model model) {
		if (opType == null)
			System.out.println("ciaone");
		switch (opType) {
		case "":
			break;
		case "ciao":
			break;
		case "ciaone":
			break;
		default:
			
			break;
		}
		return catalogPath;
	}
}
