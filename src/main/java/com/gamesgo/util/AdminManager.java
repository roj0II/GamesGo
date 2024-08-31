package com.gamesgo.util;

import com.gamesgo.model.User;

public class AdminManager {
	
	public static String checkAdmin (User loggedUser, String path) {
		if (loggedUser!=null) {
			if (loggedUser.isAdmin()) {
				return path;
			}
		}
        return "redirect:/404";
	}
}
