package com.gamesgo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gamesgo.dto.UserDto;
import com.gamesgo.dto.builder.UserDtoBuilder;
import com.gamesgo.interfaces.CrudControllerI;
import com.gamesgo.model.User;
import com.gamesgo.repository.UserRepository;

@Controller
@RequestMapping("user")
public class UserController implements CrudControllerI<UserDto> {
	@Autowired
	private UserRepository uRep;

	@GetMapping("/")
	public String main(Model model) {
		model.addAttribute("users", uRep.findAll());
		return "user.jsp";
	}

	@GetMapping("insert")
	public String preInsert(Model model) {
		UserDto dtUser = new UserDto();
		model.addAttribute("userForm", dtUser);
		return "insertUser.jsp";
	}

	@PostMapping("insert")
	public String insert(Model model, @ModelAttribute("userForm") UserDto dto) {
		/*
		 * Verifica che i campi inseriti non siano già inseriti nel DB, quindi fa una
		 * ricerca in base a quei campi
		 */
		User userName = uRep.findByUsername(UserDtoBuilder.fromDtoToEntity(dto).getUsername());
		User userPhone = uRep.findByPhone(UserDtoBuilder.fromDtoToEntity(dto).getPhone());
		User userEmail = uRep.findByEmail(UserDtoBuilder.fromDtoToEntity(dto).getEmail());
		
		String userErr = "Username non disponibile.";
		String phoneErr = "Il numero di telefono inserito è già associato ad un altro account.";
		String emailErr = "La mail inserita è già associata ad un altro account.";
		
		if (userName != null) { // Inserimento di un username già presente.
			dto.setUsername(null); // Annulla la stringa username
			String errMsg = userErr;

			if (userPhone != null) {
				dto.setPhone(null);  // Annulla la stringa telefono
				errMsg += " " + phoneErr;
			}

			if (userEmail != null) {
				dto.setEmail(null); // Annulla la stringa email
				errMsg += " " + emailErr;
			}
			// Messaggio di errore.
			model.addAttribute("show", "show");
			model.addAttribute("message", errMsg);
			model.addAttribute("color", "red");
			model.addAttribute("title", "Errore!");

			model.addAttribute("userForm", dto);
			return "insertUser.jsp";
		} else if (userPhone != null) { // Inserimento di un telefono già presente.
			dto.setPhone(null); // Annulla la stringa telefono
			String errMsg = phoneErr;

			if (userEmail != null) {
				dto.setEmail(null); // Annulla la stringa email
				errMsg += " " + emailErr;
			}
			// Messaggio di errore.
			model.addAttribute("show", "show");
			model.addAttribute("message", errMsg);
			model.addAttribute("color", "red");
			model.addAttribute("title", "Errore!");

			model.addAttribute("userForm", dto);
			return "insertUser.jsp";
		} else if (userEmail != null) { // Inserimento di una mail già presente.
			dto.setEmail(null); // Annulla la stringa email
			String errMsg = emailErr;
			
			// Messaggio di errore.
			model.addAttribute("show", "show");
			model.addAttribute("message", errMsg);
			model.addAttribute("color", "red");
			model.addAttribute("title", "Errore!");

			model.addAttribute("userForm", dto);
			return "insertUser.jsp";
		}

		uRep.save(UserDtoBuilder.fromDtoToEntity(dto)); // Salvataggio nel DB
		return "redirect:/user/";
	}

	@GetMapping("update/{id}")
	public String preUpdate(Model model, @PathVariable int id) {
		User u = uRep.findById(id).orElse(new User());
		model.addAttribute("userForm", UserDtoBuilder.fromEntityToDto(u));
		return "/user/editUser.jsp";
	}

	@PostMapping("update")
	public String update(Model model, @ModelAttribute("userForm") UserDto dto) {
		uRep.save(UserDtoBuilder.fromDtoToEntity(dto));
		return "redirect:/user/";
	}

	@GetMapping("/delete/{id}")
	public String delete(Model model, @PathVariable int id) {
		uRep.deleteById(id);
		return "redirect:/user/";
	}

}