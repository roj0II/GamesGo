package com.gamesgo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gamesgo.dto.GenreDto;
import com.gamesgo.dto.builder.GenreDtoBuilder;
import com.gamesgo.model.Genre;
import com.gamesgo.repository.GenreRepository;

@Controller
@RequestMapping("genre")
public class GenreController {
	
	@GetMapping("/")
	public String main(Model model) {
		return "genre.jsp";
	}
	
	@Autowired
	private GenreRepository genRep;
	
	@DeleteMapping("/{id}")
	public String delete(Model model, @PathVariable int id) {
		genRep.deleteById(id);
		return "genre.jsp";
	}
	//  edit
	
	
	@GetMapping("insert")
	public String preInsert(Model model) {
		GenreDto genre = new GenreDto();
		model.addAttribute("genreForm", genre);
		return "insertGenre.jsp";
	}
	

	@PostMapping("insert")
	public String insert(Model model,@ModelAttribute("genreForm") GenreDto g) {
		genRep.save(GenreDtoBuilder.fromDtoToEntity(g));
		return "genre.jsp";
	}
	
	@GetMapping("update/{id}")
    public String preUpdate(Model model, @PathVariable int id) {
		Genre genre = genRep.findById(id).orElse(new Genre());
		
        model.addAttribute("genreForm", GenreDtoBuilder.fromEntityToDto(genre));
        return "editGenre.jsp";
    }
	
	@GetMapping("update")
    public String update(Model model,@ModelAttribute("genreForm") GenreDto g) {
		genRep.save(GenreDtoBuilder.fromDtoToEntity(g));
        return "genre.jsp";
    }
	
}
