package com.gamesgo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gamesgo.dto.CheckoutDto;
import com.gamesgo.model.Game;
import com.gamesgo.model.User;
import com.gamesgo.repository.GameRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class CheckoutController {

	private final String pathCheckoutPage = "/home/checkout.jsp";
	
	@Autowired
	private GameRepository gameRepository;
	
	@GetMapping("/checkout/{id}")
	public String checkoutForm (Model model, HttpSession session, @PathVariable int id, @RequestParam String formatType, @RequestParam String transactionType){
		// digital o retail = formatType
		// buy o rent = transactionType
		Game game = gameRepository.findById(id).orElse(new Game());
		User loggedUser = (User) session.getAttribute("loggedUser");

		CheckoutDto cd = new CheckoutDto();
		cd.setUserAddress(loggedUser.getAddress());
		cd.setUserEmail(loggedUser.getEmail());
		cd.setUserName(loggedUser.getName());
		cd.setUserSurname(loggedUser.getSurname());
		cd.setUserPhone(loggedUser.getPhone());
		
		cd.setGameTitle(game.getTitle());
		cd.setGamePhotoUrl(game.getPhotoUrl());
		if (formatType.equals("digital")) {
			cd.setGamePrice(game.getPriceDigital());
		} else {
			cd.setGamePrice(game.getPriceRetail());
		}
		
		
		model.addAttribute("check", cd);
		return pathCheckoutPage;
	}
}
