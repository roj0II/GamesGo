package com.gamesgo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.gamesgo.dto.StorageDto;
import com.gamesgo.dto.builder.StorageDtoBuilder;
import com.gamesgo.interfaces.CrudControllerI;
import com.gamesgo.model.Storage;
import com.gamesgo.repository.StorageRepository;

@Controller
@RequestMapping("storage")
public class StorageController implements CrudControllerI<StorageDto> {
	@Autowired
	private StorageRepository storageRep;

	@GetMapping("/")
	public String main(Model model) {
		model.addAttribute("storage", storageRep.findAll());
		return "storage.jsp";
	}

	@GetMapping("insert")
	public String preInsert(Model model) {
		StorageDto dtStorage = new StorageDto();
		model.addAttribute("storageForm", dtStorage);
		return "insertStorage.jsp";
	}

	@PostMapping("insert")
	public String insert(Model model, @ModelAttribute("storageForm") StorageDto dto) {
		storageRep.save(StorageDtoBuilder.fromDtoToEntity(dto));
		return "redirect:/storage/";
	}

	@GetMapping("update/{id}")
	public String preUpdate(Model model, @PathVariable int id) {
		Storage s = storageRep.findById(id).orElse(new Storage());
		model.addAttribute("storageForm", StorageDtoBuilder.fromEntityToDto(s));
		return "/storage/editStorage/";
	}

	@PostMapping("update")
	public String update(Model model, @ModelAttribute("storageForm") StorageDto dto) {
		storageRep.save(StorageDtoBuilder.fromDtoToEntity(dto));
		return "redirect:/storage/";
	}

	@GetMapping("/delete/{id}")
	public String delete(Model model, @PathVariable int id) {
		storageRep.deleteById(id);
		return "redirect:/storage/";
	}

}
