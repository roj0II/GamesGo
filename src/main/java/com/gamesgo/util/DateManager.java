package com.gamesgo.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateManager {
	public static String dateToString(Date data) {
        SimpleDateFormat itFormat = new SimpleDateFormat("dd MMMM yyyy", new Locale("it", "IT"));
        
        return itFormat.format(data);
    }
}