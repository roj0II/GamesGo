package com.gamesgo.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gamesgo.dto.ShippingDto;
import com.gamesgo.dto.builder.ShippingDtoBuilder;
import com.gamesgo.interfaces.CrudControllerI;
import com.gamesgo.model.Shipping;
import com.gamesgo.model.Transaction;
import com.gamesgo.model.User;
import com.gamesgo.repository.ShippingRepository;
import com.gamesgo.repository.TransactionRepository;
import com.gamesgo.repository.UserRepository;

import jakarta.servlet.http.HttpSession;
@Controller
@RequestMapping("/shipping")
public class ShippingController implements CrudControllerI<ShippingDto> {
	@Autowired
	ShippingRepository shippingRep;
	@Autowired
	UserRepository uRep;
	@Autowired
	TransactionRepository transRep;
	
	@Override
	@GetMapping("/")
	public String main(Model model, HttpSession session) {
		List<ShippingDto> shippingDtoList=new ArrayList<>();
		List<Shipping> shippingList=new ArrayList<>();
		shippingList=shippingRep.findAll();
		for(Shipping s:shippingList) {
			shippingDtoList.add(ShippingDtoBuilder.fromEntityToDto(s));
		}
		model.addAttribute("shippingListForm", shippingDtoList);
		return "shipping.jsp";
	}

	@Override
	@GetMapping("/insert")
	public String preInsert(Model model, HttpSession session) {
		ShippingDto shippingDto=new ShippingDto();
		model.addAttribute("shippingForm", shippingDto);
		model.addAttribute("users",uRep.findAll().stream()
	            .sorted(Comparator.comparing(User::getUsername))
	            .toList());
		model.addAttribute("trans",transRep.findAll().stream()
	            .sorted(Comparator.comparing(Transaction::getId))
	            .toList());
		return "/shipping/insertShipping.jsp";
	}

	@Override
	@PostMapping("/insert")
	public String insert(Model model, HttpSession session,@ModelAttribute("shippingForm") ShippingDto dto) {
		Shipping shipping=ShippingDtoBuilder.fromDtoToEntity(dto);
		shippingRep.save(shipping);
		return "redirect:/shipping/";
	}

	@Override
	@GetMapping("/update/{id}")
	public String preUpdate(Model model, HttpSession session,@PathVariable int id) {
		Shipping shipping=shippingRep.findById(id).orElse(new Shipping());
		ShippingDto shippingDto=ShippingDtoBuilder.fromEntityToDto(shipping);
		model.addAttribute("shippingForm", shippingDto);
		model.addAttribute("users",uRep.findAll().stream()
	            .sorted(Comparator.comparing(User::getUsername))
	            .toList());
		model.addAttribute("trans",transRep.findAll().stream()
	            .sorted(Comparator.comparing(Transaction::getId))
	            .toList());
		return "/shipping/editShipping.jsp";
	}

	@Override
	@PostMapping("/update")
	public String update(Model model, HttpSession session, @ModelAttribute("shippingForm")ShippingDto dto) {
		Shipping shipping=ShippingDtoBuilder.fromDtoToEntity(dto);
		shippingRep.save(shipping);
		
		return "redirect:/shipping/";
	}

	@Override
	@GetMapping("/delete/{id}")
	public String delete(Model model, HttpSession session, @PathVariable int id) {
		shippingRep.deleteById(id);
		return "redirect:/shipping/";
	}

}
