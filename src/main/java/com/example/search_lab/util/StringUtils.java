package com.example.search_lab.util;

import java.util.ArrayList;
import java.util.List;

public final class StringUtils {

    private StringUtils() {

    }

    public static String convertFromAscii(List<Integer> asciiCodes) {
        StringBuilder stringBuilder = new StringBuilder(asciiCodes.size());
        for (Integer code : asciiCodes) {
            stringBuilder.append((char) code.intValue());
        }
        return stringBuilder.toString();
    }

    public static List<Integer> getAsciiCodes(String s) {
        char[] chars = s.toCharArray();
        List<Integer> out = new ArrayList<>(s.length());
        for (char c : chars) {
            out.add((int) c);
        }
        return out;
    }
}
