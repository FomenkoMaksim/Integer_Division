package com.foxminded.fomenkomaksim.integer.division.misc;

import java.util.Arrays;

public class StringUtils {
    private StringUtils() {
    }

    public static String stringOfChar(char fill, int len) {
        char[] charArray = new char[len];
        Arrays.fill(charArray, fill);
        return new String(charArray);
    }

    public static String dashLine(int len) {
        return stringOfChar('-', len);
    }

    public static String spacer(int len) {
        return stringOfChar(' ', len);
    }
}
