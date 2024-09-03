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
import com.gamesgo.util.AdminManager;
import com.gamesgo.util.EmailManager;
import com.gamesgo.util.OTPCodeGenerator;
import com.gamesgo.util.PasswordManager;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;

	@Autowired
	private OtpRepository otpRep;

	@GetMapping("/login")
	public String login(HttpSession session) {
		// model.setAttribute("accediForm", "");
		// model.setAttribute("otpForm", "hidden");
		return "login/loginPage.jsp";
	}

	@GetMapping("/admin")
	public String admin(Model model, HttpSession session) {
		// se l'utente non è loggato, gli mostreremo una pagina
		// se è loggato ma non è admin, redirect:/404;
		User loggedUser = (User) session.getAttribute("loggedUser");
        return AdminManager.checkAdmin(loggedUser,"admin/index.html");
	}
	@GetMapping("/logout")
	public String logout(Model model, HttpSession session) {
		// se l'utente non è loggato, gli mostreremo una pagina
		// se è loggato ma non è admin, redirect:/404;
		session.invalidate();
        return "redirect:/login";
	}
	
	
	@PostMapping("/login")
	public String adminLogin(Model model, HttpSession session, HttpServletRequest request, @RequestParam String username,
			@RequestParam String password) throws MessagingException, IOException {
		boolean adminLogin = false;
		if (username.toLowerCase().startsWith("admin_")) {
			username = username.substring(6);
			adminLogin = true;
		}
		boolean authenticated = userService.authenticate(username, password);
		if (authenticated) {
			User user = userService.findByUsername(username);
			if (user.isAdmin() && adminLogin) {
				model.addAttribute("accediForm", "hidden");
				model.addAttribute("otpForm", "");
				// inserisco l'otp nel database, con l'id dell'utente. user.getId();

				String otpCode = OTPCodeGenerator.generateOTPCode();
				
				// Stampo il codice in console per fare i test.
				System.out.println(otpCode);
				
				// Creiamo un codice otp da associare all'utente ed inserire nel db.
				Otp otp = new Otp();
				otp.setCode(otpCode);
				otp.setUser(user);
				otpRep.save(otp);

				// Inviamo l'email all'utente con il codice.
				// Tolto per fare i test.
				//EmailManager.sendMail(user.getEmail(), otpCode);

				return "login/loginPage.jsp";
				// ritorniamo la pagina che verrà modificata per l'otp.
			} else {
				
				// Inseriamo in sessione, l'utente che ha eseguito l'accesso con successo.
				user.setAdmin(false);
				request.getSession().setAttribute("loggedUser", user);
				// apriamo la pagina home.
		        return "redirect:/";
			}
		} else if (username.equals("sex")) {
			model.addAttribute("error", true);
			model.addAttribute("message", "Sei sexy!");
			model.addAttribute("color", "blue");
			model.addAttribute("title", "(^_^ )");

			session.setAttribute("accediForm", "");
			session.setAttribute("otpForm", "hidden");
			// ritorno la pagina con il messaggio d'errore.
			return "login/loginPage.jsp";
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
	public String adminLoginOtp(Model model, HttpSession session, HttpServletRequest request, @RequestParam String otp) {
			User loggedUser = (User) session.getAttribute("loggedUser");
		Otp o = otpRep.findByCode(otp);
		if (o != null) {
			// Assegnamo alla sessione lo user ADMIN.
			loggedUser=o.getUser();
			request.getSession().setAttribute("loggedUser", loggedUser);
			// Eliminiamo l'Otp usato.
			otpRep.delete(o);
	        return AdminManager.checkAdmin(loggedUser,"admin/index.html");
		}

		model.addAttribute("error", true);
		model.addAttribute("message", "Codice otp errato.");
		model.addAttribute("color", "red");
		model.addAttribute("title", "Errore");
		
		// Errore, otp non trovato.
		return "login/loginPage.jsp";
	}

	@PostMapping("/register")
	public String register(Model model, HttpSession session, @RequestParam String username, @RequestParam String name,
			@RequestParam String surname, @RequestParam String email, @RequestParam String address,
			@RequestParam String phoneNumber, @RequestParam String password, @RequestParam String confermaPassword) {
		if (!isValidUsername(username)) {
			model.addAttribute("error", true);
			model.addAttribute("message", "Sono consentiti solo caratteri alfanumerici, underscores, trattini e punti.");
			model.addAttribute("color", "red");
			model.addAttribute("title", "Username non valido");

			model.addAttribute("registerForm", "right-panel-active");
			
			return "login/loginPage.jsp";
        } 
		boolean registered;
		if (password.equals(confermaPassword)) {
			User user = new User(username, name, surname, address, phoneNumber, email,
					PasswordManager.hashPassword(password), false);
			registered = userService.register(user);
		} else {
			registered = false;
		}
		if (registered) {
			model.addAttribute("error", true);
			model.addAttribute("message", "Ora puoi effettuare l'accesso.");
			model.addAttribute("color", "green");
			model.addAttribute("title", "Registrato correttamente!");

			return "login/loginPage.jsp";
		} else {
			model.addAttribute("error", true);
			model.addAttribute("message", "Utente già esistente o password non confermata.");
			model.addAttribute("color", "red");
			model.addAttribute("title", "Error!");

			model.addAttribute("registerForm", "right-panel-active");
			return "login/loginPage.jsp";
		}
	}
	
	// Metodo per controllare se un username contiene solo caratteri consentiti
	public static boolean isValidUsername(String s) {
        // Regex che permette lettere, numeri, underscore, trattino e punto
        return s.matches("[a-zA-Z0-9._-]+");
    }

}