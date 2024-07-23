package com.gamesgo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gamesgo.model.User;
import com.gamesgo.service.UserService;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/login")
	public String login () {
		return "loginPage.jsp";
	}
	
	@PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        boolean authenticated = userService.authenticate(username, password);
        if (authenticated) {
        	User user = userService.findByUsername(username);
        	if (user.isAdmin()) {
        		// ritorniamo la pagina che verrà modificata per l'otp.
        	} else {
        		
        	}
            return "Login successful";
        } else {
            return "Invalid username or password";
        }
    }

    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String name, @RequestParam String surname, @RequestParam String email, @RequestParam String address,
                           @RequestParam String phoneNumber, @RequestParam String password) {
    	System.out.println(username);
        User user = new User(username, name, surname, address, phoneNumber, email, password, false);
        boolean registered = userService.register(user);
        if (registered) {
        	// Aggiungiamo un messaggio di successo con la sessione.
    		return "loginPage.jsp";
        } else {
        	// aggiungiamo un messaggio di errore con la sessione.
    		return "loginPage.jsp";
        }
    }
    
}