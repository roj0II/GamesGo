package com.gamesgo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.gamesgo.dto.GenreDto;
import com.gamesgo.dto.builder.GenreDtoBuilder;
import com.gamesgo.interfaces.CrudControllerI;
import com.gamesgo.model.Genre;
import com.gamesgo.repository.GenreRepository;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("genre")
public class GenreController implements CrudControllerI<GenreDto> {
	
	@Autowired
	private GenreRepository genRep;
	
	@GetMapping("/")
	public String main(Model model, HttpSession session) {
        model.addAttribute("genres", genRep.findAll());
		return "genre.jsp";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(Model model, HttpSession session, @PathVariable int id) {
		genRep.deleteById(id);
		return "redirect:/genre/";
	}
	
	@GetMapping("insert")
	public String preInsert(Model model, HttpSession session) {
		GenreDto genre = new GenreDto();
		model.addAttribute("genreForm", genre);
		return "insertGenre.jsp";
	}

	@PostMapping("insert")
	public String insert(Model model, HttpSession session,@ModelAttribute("genreForm") GenreDto g) {
		Genre genre = genRep.findByName(GenreDtoBuilder.fromDtoToEntity(g).getName());
		if (genre!=null) { // se troviamo un Genre con il nome uguale a quell che stiamo inserendo, ERORRE, già esiste quel genere.
			
			

        	model.addAttribute("show", "show");
        	model.addAttribute("message", "Questo nome esiste già.");
        	model.addAttribute("color", "red");
        	model.addAttribute("title", "Error!");
			// messaggio d'errore.
			model.addAttribute("genreForm", g);
			return "insertGenre.jsp";
		} 
		genRep.save(GenreDtoBuilder.fromDtoToEntity(g));
		return "redirect:/genre/";
	}
	
	@GetMapping("update/{id}")
    public String preUpdate(Model model, HttpSession session, @PathVariable int id) {
		Genre genre = genRep.findById(id).orElse(new Genre());
		
        model.addAttribute("genreForm", GenreDtoBuilder.fromEntityToDto(genre));
        return "/genre/editGenre.jsp";
    }
	
	@PostMapping("update")
    public String update(Model model, HttpSession session,@ModelAttribute("genreForm") GenreDto g) {
		genRep.save(GenreDtoBuilder.fromDtoToEntity(g));
		return "redirect:/genre/";
	}
}
