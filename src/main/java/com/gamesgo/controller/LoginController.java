package com.gamesgo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gamesgo.model.User;
import com.gamesgo.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/login")
	public String login (HttpSession session) {
        session.setAttribute("accediForm", "");
        session.setAttribute("otpForm", "hidden");
		return "login/loginPage.jsp";
	}
	
	@GetMapping("/admin")
	public String admin () {
		return "admin/index.html";
	}
	
	@PostMapping("/login")
	public String adminLogin (HttpSession session,@RequestParam String username, @RequestParam String password) {
		System.out.println(username);
		boolean adminLogin = false;
		if (username.toLowerCase().startsWith("admin_")) {
			username = username.substring(6);
			System.out.println(username + " " + password);
			adminLogin = true;
		}
		boolean authenticated = userService.authenticate(username, password);
		System.out.println(authenticated);
        if (authenticated) {
        	User user = userService.findByUsername(username);
        	if (user.isAdmin() && adminLogin) {
                session.setAttribute("accediForm", "hidden");
                session.setAttribute("otpForm", "");
                // inserisco l'otp nel database, con l'id dell'utente. user.getId();
                
                System.out.println("inviamo un otp all'email associata all'account.");
        		return "login/loginPage.jsp";
        		// ritorniamo la pagina che verrà modificata per l'otp.
        	} else {
        		// apriamo la pagina con il catalogo.
        		return "";
        	}
        } else {
        	// ritorno la pagina con il messaggio d'errore.
            return "Invalid username or password";
        }
	}
	
	@PostMapping("/logAdmin")
	public String adminLoginOtp (HttpSession session,@RequestParam String otp) {
		System.out.println(otp);
		// cerco nel database il codice otp, se c'è prendo l'utente e lo imposto nella sessione dell'utente. sennò errore.
		return "admin/index.html";
	}
	
    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String name, @RequestParam String surname, @RequestParam String email, @RequestParam String address,
                           @RequestParam String phoneNumber, @RequestParam String password) {
    	System.out.println(username);
        User user = new User(username, name, surname, address, phoneNumber, email, password, false);
        boolean registered = userService.register(user);
        if (registered) {
        	// Aggiungiamo un messaggio di successo con la sessione.
    		return "login/loginPage.jsp";
        } else {
        	// aggiungiamo un messaggio di errore con la sessione.
    		return "loginPage.jsp";
        }
    }
    
}