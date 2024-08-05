package com.gamesgo.controller;

import java.io.IOException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gamesgo.model.Otp;
import com.gamesgo.model.User;
import com.gamesgo.repository.OtpRepository;
import com.gamesgo.service.UserService;
import com.gamesgo.util.EmailManager;
import com.gamesgo.util.OTPCodeGenerator;
import com.gamesgo.util.PasswordManager;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private OtpRepository otpRep;
	
	@GetMapping("/login")
	public String login (HttpSession session) {
		// model.setAttribute("accediForm", "");
		// model.setAttribute("otpForm", "hidden");
		return "login/loginPage.jsp";
	}
	
	@GetMapping("/admin")
	public String admin () {
		return "admin/index.html";
	}
	
	@PostMapping("/login")
	public String adminLogin (Model model, HttpSession session,@RequestParam String username, @RequestParam String password) throws MessagingException, IOException {
		System.out.println("Username? " + username);
		boolean adminLogin = false;
		if (username.toLowerCase().startsWith("admin_")) {
			username = username.substring(6);
			System.out.println(username + " " + password);
			adminLogin = true;
		}
		boolean authenticated = userService.authenticate(username, password);
		System.out.println("Autenticato? " + authenticated);
        if (authenticated) {
        	User user = userService.findByUsername(username);
        	if (user.isAdmin() && adminLogin) {
        		model.addAttribute("accediForm", "hidden");
        		model.addAttribute("otpForm", "");
                // inserisco l'otp nel database, con l'id dell'utente. user.getId();

                String otpCode = OTPCodeGenerator.generateOTPCode();
                
                // Creiamo un codice otp da associare all'utente ed inserire nel db.
                Otp otp = new Otp();
                otp.setCode(otpCode);
                otp.setUser(user);
                otpRep.save(otp);
                
                // Inviamo l'email all'utente con il codice.
                EmailManager.sendMail(user.getEmail(), otpCode);
                
                return "login/loginPage.jsp";
        		// ritorniamo la pagina che verrà modificata per l'otp.
        	} else {
        		// apriamo la pagina con il catalogo.
        		return "apriamo la pagina con il catalogo.";
        	}
        } else {
        	System.out.println("Username o Password non validi.");
        	
        	model.addAttribute("error", true);
        	model.addAttribute("message", "Username o Password non validi.");
        	model.addAttribute("color", "red");
        	model.addAttribute("title", "Error!");

            session.setAttribute("accediForm", "");
            session.setAttribute("otpForm", "hidden");
        	// ritorno la pagina con il messaggio d'errore.
            return "login/loginPage.jsp";
        }
	}
	
	@GetMapping("/logAdmin")
	public String adminLoginOtp (HttpSession session,@RequestParam String otp) {
		System.out.println("Admin LOGIN");
		System.out.println(otp);
		Otp o = otpRep.findByCode(otp);
		if (o!=null) {
			// Assegnamo alla sessione l'user.
			session.setAttribute("user", o.getUser());
			// Eliminiamo l'Otp usato.
			otpRep.delete(o);
			return "admin/index.html";
		}
		
		// Errore, otp non trovato.
        return "login/loginPage.jsp";
	}
	
    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String name, @RequestParam String surname, @RequestParam String email, @RequestParam String address,
                           @RequestParam String phoneNumber, @RequestParam String password) {
    	System.out.println(username);
        User user = new User(username, name, surname, address, phoneNumber, email, PasswordManager.hashPassword(password), false);
        boolean registered = userService.register(user);
        if (registered) {
        	// Ricarichiamo la pagina | con o senza messaggio di successo.
    		return "login/loginPage.jsp";
        } else {
        	// Mandiamo un errore e ricarichiamo la pagina.
        	return "loginPage.jsp";
        }
    }
    
}