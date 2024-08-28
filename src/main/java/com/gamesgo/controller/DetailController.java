package com.gamesgo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.gamesgo.model.Game;
import com.gamesgo.repository.GameRepository;

@Controller
public class DetailController {
	@Autowired
	private GameRepository gameRep;
	
	final private static String detailPath = "../home/product-details.jsp";
	
	@GetMapping("/detail/{id}")
	public String detail(Model model, @PathVariable int id) {
		model.addAttribute("game", gameRep.findById(id).orElse(new Game()));
		return detailPath;
	}
}
