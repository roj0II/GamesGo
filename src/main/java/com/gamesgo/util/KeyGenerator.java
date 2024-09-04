package com.gamesgo.util;

public class KeyGenerator {

    public static String generateProductKey() {
    	String timestampSegment = RandomSegmentGenerator.getTimestampSegment(6);

        String randomSegment1 = RandomSegmentGenerator.generateRandomString(6);
        String randomSegment2 = RandomSegmentGenerator.generateRandomString(6);
        return randomSegment1 + "-" + timestampSegment + "-" + randomSegment2;
    }
    
}
