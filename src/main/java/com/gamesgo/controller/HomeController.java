package com.gamesgo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.gamesgo.util.WebhookManager;

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
	
	@PostMapping("/contact")
	public String contactUs (Model model,
			@RequestParam("name") String name,
			@RequestParam("surname") String surname,
			@RequestParam("email") String email,
			@RequestParam("subject") String subject,
			@RequestParam("message") String message
	) throws Exception {
		
		WebhookManager.sendWebhook("https://discord.com/api/webhooks/1280482865393569843/o-PwN4IXGJzw8B-dM6ppPOnsI3PAlsmE4mGH8GOhj1FenH5nUPZ9AKmsct1Y3uCPjLmX", WebhookManager.embedContact(name, surname, subject, email, message));

        return "redirect:/contact";
	}
	
	
}
