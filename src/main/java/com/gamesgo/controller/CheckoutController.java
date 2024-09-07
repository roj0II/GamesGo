package com.gamesgo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gamesgo.dto.CheckoutDto;
import com.gamesgo.dto.GameDto;
import com.gamesgo.model.Game;
import com.gamesgo.model.User;
import com.gamesgo.repository.GameRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class CheckoutController {

	private final String pathCheckoutPage = "/home/checkout.jsp";
	
	@Autowired
	private GameRepository gameRepository;
	
	@PostMapping("/checkout/{id}")
	public String checkoutForm (Model model, HttpSession session, @PathVariable int id, @RequestParam String formatType, @RequestParam String transactionType){
		// digital o retail = formatType
		// buy o rent = transactionType
		Game game = gameRepository.findById(id).orElse(new Game());
		User loggedUser = (User) session.getAttribute("loggedUser");

		if (loggedUser == null) {
			model.addAttribute("error", true);
			model.addAttribute("message", "Effettua prima l'accesso.");
			model.addAttribute("color", "yellow");
			model.addAttribute("title", "Alert!");
			
			return "/login/loginPage.jsp";
		}
		
		CheckoutDto cd = new CheckoutDto();
		cd.setTransactionAddress(loggedUser.getAddress());
		cd.setTransactionEmail(loggedUser.getEmail());
		cd.setTransactionName(loggedUser.getName());
		cd.setTransactionPhone(loggedUser.getPhone());
		cd.setTransactionSurname(loggedUser.getSurname());
		
		cd.setShippingAddress(loggedUser.getAddress());
		cd.setShippingEmail(loggedUser.getEmail());
		cd.setShippingName(loggedUser.getName());
		cd.setShippingPhone(loggedUser.getPhone());
		cd.setShippingSurname(loggedUser.getSurname());
		
		cd.setPaymentNameAndSurname(loggedUser.getName()+ " "+loggedUser.getSurname());
		
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
		
		if (transactionType.equals("rent")) {
			cd.setGamePrice((float) (cd.getGamePrice()/30 - 0.20));
		}
		
		cd.setOnline(formatType.equals("digital"));
		cd.setRent(transactionType.equals("rent"));
		
		
		
		model.addAttribute("check", cd);
		return pathCheckoutPage;
	}
	
	@PostMapping("/final")
	public String checkout(Model model, HttpSession session, @ModelAttribute("check") CheckoutDto checkoutDto){
		
		// controlliamo se è un buy o rent.
		if (checkoutDto.isRent()) { // rent.
			
			if (checkoutDto.isOnline()) { // online.
				
				
				
			} else { // fisico.
				
			}
			
		} else { // buy.
			
			if (checkoutDto.isOnline()) { // online.
				
			} else { // fisico.
				
			}
			
		}
		
		return "";
	}
}
