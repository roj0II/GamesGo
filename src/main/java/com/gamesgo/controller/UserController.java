//package com.gamesgo.controller;
//
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import com.gamesgo.dto.GameGenreDto;
//import com.gamesgo.interfaces.CrudControllerI;
//
//public class UserController implements CrudControllerI<GameGenreDto> {
//
//	@GetMapping("/")
//	public String main(Model model) {
//		model.addAttribute("users", gameGenreRep.findAll());
//		return "user.jsp";
//	}
//
//	@Override
//	public String preInsert(Model model) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String insert(Model model, GameGenreDto dto) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String preUpdate(Model model, int id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String update(Model model, GameGenreDto dto) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String delete(Model model, int id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//}
