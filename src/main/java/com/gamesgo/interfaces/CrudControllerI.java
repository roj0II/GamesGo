package com.gamesgo.interfaces;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import jakarta.servlet.http.HttpSession;

/**
 * {@code CrudControllerI} serve a dare un'impronta ai controller che gestiranno direttamente l'entità.
 * @param Dto intendiamo il Dto dell'entità che stiamo andando ad usare.
 * @author Michele
 */
public interface CrudControllerI<Dto> {
	String main(Model model, HttpSession session);
	String preInsert(Model model, HttpSession session);
	String insert(Model model, HttpSession session, Dto dto);
	String preUpdate(Model model, HttpSession session, @PathVariable int id);
	String update(Model model, HttpSession session, Dto dto);
	String delete(Model model, HttpSession session, @PathVariable int id);
}
