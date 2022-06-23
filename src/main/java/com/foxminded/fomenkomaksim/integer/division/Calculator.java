package com.foxminded.fomenkomaksim.integer.division;

public class Calculator {
    Result result = new Result();
    Step steps;

    private int answer;
    private int reminder;

    public Result divide(int dividend, int divisor) {
        String[] digits = Integer.toString(dividend).split("");
        int tempDividend = Integer.parseInt(digits[0]);
        int x = 0;

        while (x < digits.length - 1) {
            for (int i = 0; i <= digits.length - 1; i++) {
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

                    steps = new Step(tempDividend, subtraction);
                    result.getStepsList().add(steps);
                    tempDividend = reminder;
                }
            }
        }

        result.setQuotient(answer);
        result.setReminder(reminder);
        return result;
    }
}
