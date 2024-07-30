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
		uRep.save(UserDtoBuilder.fromDtoToEntity(dto));
		return "redirect:/gamegenre/";
	}

	@GetMapping("update/{id}")
	public String preUpdate(Model model, @PathVariable int id) {
		User u = uRep.findById(id).orElse(new User());
		model.addAttribute("userForm", UserDtoBuilder.fromEntityToDto(u));
		return "/user/editUser.jsp";
	}

	@PostMapping("update")
	public String update(Model model,@ModelAttribute("userForm") UserDto dto) {
		uRep.save(UserDtoBuilder.fromDtoToEntity(dto));
		return "redirect:/user/";
	}

	@GetMapping("/delete/{id}")
	public String delete(Model model, @PathVariable int id) {
		uRep.deleteById(id);
		return "redirect:/user/";
	}

	

	

}
