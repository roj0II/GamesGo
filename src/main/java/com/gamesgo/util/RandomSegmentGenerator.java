package com.gamesgo.util;

import java.security.SecureRandom;
import java.time.Instant;

public class RandomSegmentGenerator {
	

    public static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    public static final String NUMBERS = "0123456789";

    private static final SecureRandom RANDOM = new SecureRandom();
	
	public static String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
        }
        return sb.toString();
    }
	
	public static String generateRandomNumber(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(NUMBERS.charAt(RANDOM.nextInt(NUMBERS.length())));
        }
        return sb.toString();
    }	

    public static String getTimestampSegment(int length) {
        // Usa il tempo corrente in millisecondi e prendi i primi 10 caratteri numerici
        long timestamp = Instant.now().toEpochMilli();
        String timestampStr = Long.toString(timestamp);

        // Se il timestamp è più corto di 10 caratteri, riempi con zeri
        if (timestampStr.length() < length) {
            timestampStr = String.format("%010d", Long.parseLong(timestampStr));
        }

        // Prendi i primi 10 caratteri del timestamp
        return timestampStr.substring(0, length);
    }
}
