package com.gamesgo.controller;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gamesgo.dto.RentDto;
import com.gamesgo.dto.builder.GameDtoBuilder;
import com.gamesgo.dto.builder.RentDtoBuilder;
import com.gamesgo.interfaces.CrudControllerI;
import com.gamesgo.model.Rent;
import com.gamesgo.repository.GameRepository;
import com.gamesgo.repository.RentRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
@Controller
@RequestMapping("/rent")
public class RentController implements CrudControllerI<RentDto>{
	@Autowired
	RentRepository rentRep;
	@PersistenceContext
	private EntityManager entityManager;
	@Override
	@GetMapping("/")
	public String main(Model model) {
		List<RentDto> rentDtoList=new ArrayList<>();
		List<Rent> rentList=new ArrayList<>();
		rentList=rentRep.findAll();
		for(Rent r:rentList) {
			rentDtoList.add(RentDtoBuilder.fromEntityToDto(r));
		}
		model.addAttribute("rentListForm",rentDtoList);
		return "/rent/rent.jsp";
	}

	@Override
	@GetMapping("/insert")
	public String preInsert(Model model) {
		RentDto rentDto=new RentDto();
		model.addAttribute("rentForm",rentDto);
		return "/rent/insertRent.jsp";
	}

	@Override
	@PostMapping("/insert")
	public String insert(Model model,@ModelAttribute("rentForm" ) RentDto dto) {
		Rent rent=RentDtoBuilder.fromDtoToEntity(dto);
		rentRep.save(rent);
		return "redirect:/rent/";
	}

	@Override
	@GetMapping("/update/{id}")
	public String preUpdate(Model model,@PathVariable int id) {
		Rent rent=rentRep.findById(id).orElse(new Rent());
		RentDto rentDto=RentDtoBuilder.fromEntityToDto(rent);
		model.addAttribute("rentForm", rentDto);
		return "/rent/editRent.jsp";
	}

	@Override
	@PostMapping("/update")
	public String update(Model model, @ModelAttribute("rentForm") RentDto dto) {
		Rent rent=RentDtoBuilder.fromDtoToEntity(dto);
		rentRep.save(rent);
		return "redirect:/rent/";
	}

	@Override
	@GetMapping("/delete/{id}")
	public String delete(Model model,@PathVariable int id) {
		rentRep.deleteById(id);
		return "redirect:/rent/";
	}

}
