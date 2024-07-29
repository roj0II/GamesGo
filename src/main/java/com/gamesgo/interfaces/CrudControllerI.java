package com.gamesgo.interfaces;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * {@code CrudControllerI} serve a dare un'impronta ai controller che gestiranno direttamente l'entità.
 * @param Dto intendiamo il Dto dell'entità che stiamo andando ad usare.
 * @author Michele
 */
public interface CrudControllerI<Dto> {
	String main(Model model);
	String preInsert(Model model);
	String insert(Model model, Dto dto);
	String preUpdate(Model model, @PathVariable int id);
	String update(Model model, Dto dto);
	String delete(Model model, @PathVariable int id);
}
