package com.gamesgo.controller;

import java.io.IOException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gamesgo.model.Otp;
import com.gamesgo.model.User;
import com.gamesgo.repository.OtpRepository;
import com.gamesgo.service.UserService;
import com.gamesgo.util.EmailManager;
import com.gamesgo.util.OTPCodeGenerator;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private OtpRepository otpRep;
	
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
	public String adminLogin (HttpSession session,@RequestParam String username, @RequestParam String password) throws MessagingException, IOException {
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

                String otpCode = OTPCodeGenerator.generateOTPCode();
                
                // Creiamo un codice otp da associare all'utente ed inserire nel db.
                Otp otp = new Otp();
                otp.setCode(otpCode);
                otp.setUser(user);
                otpRep.save(otp);
                
                // Inviamo l'email all'utente con il codice.
                EmailManager.sendMail(user.getEmail(), otpCode);
                
                // ritorniamo la pagina login, con la vista dell'otp.
                session.setAttribute("accediForm", "hidden");
                session.setAttribute("otpForm", "");
                return "login/loginPage.jsp";
        		// ritorniamo la pagina che verrà modificata per l'otp.
        	} else {
        		// apriamo la pagina con il catalogo.
        		return "apriamo la pagina con il catalogo.";
        	}
        } else {
        	// ritorno la pagina con il messaggio d'errore.
            return "Invalid username or password";
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
        User user = new User(username, name, surname, address, phoneNumber, email, password, false);
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