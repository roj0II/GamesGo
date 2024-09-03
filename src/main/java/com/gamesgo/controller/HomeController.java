package com.gamesgo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home () {
		return "home/index.jsp";
	}
	
	@GetMapping("/contact")
	public String contact () {
		return "home/contact.html";
	}
	
	@GetMapping("/logo")
	public String logo () {
		return "logo/logo.html";
	}
	
}
