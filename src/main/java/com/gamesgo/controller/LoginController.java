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
	public String login(HttpSession session) {
		// model.setAttribute("accediForm", "");
		// model.setAttribute("otpForm", "hidden");
		return "login/loginPage.jsp";
	}

	@GetMapping("/admin")
	public String admin() {
		return "admin/index.html";
	}

	@PostMapping("/login")
	public String adminLogin(Model model, HttpSession session, @RequestParam String username,
			@RequestParam String password) throws MessagingException, IOException {
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
	public String adminLoginOtp(HttpSession session, @RequestParam String otp) {
		System.out.println("Admin LOGIN");
		System.out.println(otp);
		Otp o = otpRep.findByCode(otp);
		if (o != null) {
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