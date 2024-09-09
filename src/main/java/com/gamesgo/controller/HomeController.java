package com.gamesgo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gamesgo.dto.GameSalesDTO;
import com.gamesgo.model.Game;
import com.gamesgo.model.Gamegenre;
import com.gamesgo.model.Genre;
import com.gamesgo.model.User;
import com.gamesgo.repository.GameGenreRepository;
import com.gamesgo.repository.GameRepository;
import com.gamesgo.repository.GenreRepository;
import com.gamesgo.repository.TransactionRepository;
import com.gamesgo.service.GameSalesService;
import com.gamesgo.util.WebhookManager;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	@Autowired
	private GameSalesService gameSalesService;
	
	@Autowired
	private GameRepository gameRep;
	
	@Autowired
	private GenreRepository genreRep;
	
	@Autowired
	private TransactionRepository transRep;
	
	@Autowired
	private GameGenreRepository gameGenreRep;

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("bestSellers", transRep.getList());
		model.addAttribute("randomGame", gameRep.findRandomGame());
		model.addAttribute("topGames", gameSalesService.getGameSales());
		
		List<Integer> genreIds = gameGenreRep.findTopGenreIds();
		
		List<Genre> genreList = genreRep.findAllById(genreIds);
		List<Game> gameList = new ArrayList<>();
		
		for (int i : genreIds) {
			gameList.add(gameGenreRep.findFirstByGenreId(i).getGame());
		}
		
		model.addAttribute("top5GenresGenre", genreList);		
		model.addAttribute("top5GenresGame", gameList);

		return "home/index.jsp";
	}

	@GetMapping("/contact")
	public String contact() {
		return "home/contact.jsp";
	}

	@GetMapping("/logo")
	public String logo() {
		return "logo/logo.html";
	}

	@PostMapping("/contact")
	public String contactUs(Model model, HttpSession session, @RequestParam("name") String name,
			@RequestParam("surname") String surname, @RequestParam("email") String email,
			@RequestParam("subject") String subject, @RequestParam("message") String message

	) throws Exception {
		User loggedUser = (User) session.getAttribute("loggedUser");
		WebhookManager.sendWebhook(
				"https://discord.com/api/webhooks/1280482865393569843/o-PwN4IXGJzw8B-dM6ppPOnsI3PAlsmE4mGH8GOhj1FenH5nUPZ9AKmsct1Y3uCPjLmX",
				WebhookManager.embedContact(subject, name, surname, email, message));

		return "redirect:/contact";
	}

}
