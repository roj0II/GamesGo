package com.gamesgo.util;

import java.security.SecureRandom;
import java.time.Instant;

public class OTPCodeGenerator {

    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final SecureRandom RANDOM = new SecureRandom();

    public static void main(String[] args) {
        String otpCode = generateOTPCode();
        System.out.println("Il codice OTP generato è: " + otpCode);
    }

    public static String generateOTPCode() {
        // Genera il timestamp corrente come una stringa di 10 caratteri
        String timestampSegment = getTimestampSegment();

        // Genera tre gruppi di 10 caratteri casuali
        String randomSegment1 = generateRandomString(10, CHARACTERS);
        String randomSegment2 = generateRandomString(10, CHARACTERS);
        String randomSegment3 = generateRandomString(10, CHARACTERS);

        // Combina i tre gruppi e il segmento del timestamp in formato desiderato
        return randomSegment1 + "-" + timestampSegment + "-" + randomSegment2 + "-" + randomSegment3;
    }

    private static String generateRandomString(int length, String characters) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(characters.charAt(RANDOM.nextInt(characters.length())));
        }
        return sb.toString();
    }

    private static String getTimestampSegment() {
        // Usa il tempo corrente in millisecondi e prendi i primi 10 caratteri numerici
        long timestamp = Instant.now().toEpochMilli();
        String timestampStr = Long.toString(timestamp);

        // Se il timestamp è più corto di 10 caratteri, riempi con zeri
        if (timestampStr.length() < 10) {
            timestampStr = String.format("%010d", Long.parseLong(timestampStr));
        }

        // Prendi i primi 10 caratteri del timestamp
        return timestampStr.substring(0, 10);
    }
}
