package com.foxminded.fomenkomaksim.integer.division.misc;

import java.util.LinkedList;
import java.util.List;

public class MathUtils {
    private MathUtils() {
    }

    public static int length(int num) {
        return num < 10 ? 1 : (int) (Math.log10(num) + 1);
    }

    public static List<Integer> toDigits(int num) {
        List<Integer> digits = new LinkedList<>();
        int current = num;
        while (current > 0) {
            digits.add(0, current % 10);
            current /= 10;
        }
        return digits;
    }
}
