package com.foxminded.fomenkomaksim.integer.division;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private int answer;
    private int reminder;
    List<Step> calcSteps = new ArrayList<>();

    public Result divide(int dividend, int divisor) {
        String[] digits = Integer.toString(dividend).split("");
        int tempDividend = Integer.parseInt(digits[0]);
        int x = 0;
        int y = 0;

        while (x < digits.length - 1) {
            for (int i = y; i <= digits.length - 1; i++) {
                if (tempDividend / divisor == 0) {
                    if (x + 1 >= digits.length) {
                        break;
                    }
                    tempDividend = Integer.parseInt(tempDividend + "" + Integer.parseInt(digits[x + 1]));
                    i--;
                    x++;
                } else {
                    answer = Integer.parseInt(answer + "" + tempDividend / divisor);
                    reminder = tempDividend % divisor;
                    int subtraction = tempDividend - reminder;

                    calcSteps.add(new Step(tempDividend, subtraction));
                    tempDividend = reminder;
                }
            }
        }

        return new Result(IntegerDivisionApp.DIVIDEND, IntegerDivisionApp.DIVISOR, reminder, answer, calcSteps);
    }
}
