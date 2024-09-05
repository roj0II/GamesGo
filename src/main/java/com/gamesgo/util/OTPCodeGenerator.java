package com.gamesgo.util;

import java.security.SecureRandom;
import java.time.Instant;

public class OTPCodeGenerator {


    public static void main(String[] args) {
        String otpCode = generateOTPCode();
        System.out.println("Il codice OTP generato è: " + otpCode);
    }

    public static String generateOTPCode() {
    	String timestampSegment = RandomSegmentGenerator.getTimestampSegment(10);

        // Generiamo tre gruppi di 10 caratteri casuali
        String randomSegment1 = RandomSegmentGenerator.generateRandomString(10);
        String randomSegment2 = RandomSegmentGenerator.generateRandomString(10);
        String randomSegment3 = RandomSegmentGenerator.generateRandomString(10);
        return randomSegment1 + "-" + timestampSegment + "-" + randomSegment2 + "-" + randomSegment3;
    }

}
