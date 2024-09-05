package com.gamesgo.controller;

import java.util.Comparator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.gamesgo.dto.TransactionDto;
import com.gamesgo.dto.builder.TransactionDtoBuilder;
import com.gamesgo.interfaces.CrudControllerI;
import com.gamesgo.model.Game;
import com.gamesgo.model.Transaction;
import com.gamesgo.model.User;
import com.gamesgo.repository.GameRepository;
import com.gamesgo.repository.TransactionRepository;
import com.gamesgo.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("transaction")
public class TransactionController implements CrudControllerI<TransactionDto> {
	@Autowired
	private TransactionRepository transRep;
	@Autowired
	private GameRepository gameRep;
	@Autowired
	private UserRepository uRep;

	@GetMapping("/")
	public String main(Model model, HttpSession session) {
		model.addAttribute("transactions", transRep.findAll());
		return "transaction.jsp";
	}

	@GetMapping("insert")
	public String preInsert(Model model, HttpSession session) {
		TransactionDto dtoTransaction = new TransactionDto();
		model.addAttribute("transactionForm", dtoTransaction);
		model.addAttribute("users",uRep.findAll().stream()
	            .sorted(Comparator.comparing(User::getUsername))
	            .toList());
		model.addAttribute("games",gameRep.findAll().stream()
	            .sorted(Comparator.comparing(Game::getTitle))
	            .toList());
		return "insertTransaction.jsp";
	}

	@PostMapping("insert")
	public String insert(Model model, HttpSession session, @ModelAttribute("transactionForm") TransactionDto dto) {
		if(dto.getCheckoutPayment()<0) {
			model.addAttribute("show", "show");
	    	model.addAttribute("message", "Un pagamento non può essere minore di 0.");
	    	model.addAttribute("color", "red");
	    	model.addAttribute("title", "Error!");

			model.addAttribute("TransactionForm", dto);
			return "/transaction/insertTransaction.jsp";
		}
		transRep.save(TransactionDtoBuilder.fromDtoToEntity(dto));
		return "redirect:/transaction/";
	}

	@GetMapping("update/{id}")
	public String preUpdate(Model model, HttpSession session, @PathVariable int id) {
		Transaction t = transRep.findById(id).orElse(new Transaction());
		model.addAttribute("transactionForm", TransactionDtoBuilder.fromEntityToDto(t));
		model.addAttribute("users",uRep.findAll().stream()
	            .sorted(Comparator.comparing(User::getUsername))
	            .toList());
		model.addAttribute("games",gameRep.findAll().stream()
	            .sorted(Comparator.comparing(Game::getTitle))
	            .toList());
		return "/transaction/editTransaction.jsp";
	}

	@PostMapping("update")
	public String update(Model model, HttpSession session, @ModelAttribute("transactionForm") TransactionDto dto) {
		if(dto.getCheckoutPayment()<0) {
			model.addAttribute("show", "show");
	    	model.addAttribute("message", "Un pagamento non può essere minore di 0.");
	    	model.addAttribute("color", "red");
	    	model.addAttribute("title", "Error!");

			model.addAttribute("TransactionForm", dto);
			return "/transaction/editTransaction.jsp";
		}
		transRep.save(TransactionDtoBuilder.fromDtoToEntity(dto));
		return "redirect:/transaction/";
	}

	@GetMapping("/delete/{id}")
	public String delete(Model model, HttpSession session, @PathVariable int id) {
		transRep.deleteById(id);
		return "redirect:/transaction/";
	}

}
