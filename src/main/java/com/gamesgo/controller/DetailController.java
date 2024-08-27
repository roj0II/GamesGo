package com.gamesgo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.gamesgo.repository.GameRepository;

@Controller
public class DetailController {
	@Autowired
	private GameRepository gameRep;

	@GetMapping("/detail")
	public String detail(Model model, int gameId) {
		model.addAttribute("gameById", gameRep.findById(gameId));
		return "detail/detail.jsp";
	}
}
