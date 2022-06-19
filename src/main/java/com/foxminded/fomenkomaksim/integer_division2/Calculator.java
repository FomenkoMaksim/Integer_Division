package com.foxminded.fomenkomaksim.integer_division2;

public class Calculator {
    Result result = new Result();
    private String answer = "";
    private int reminder = 0;

    public Result divide(int dividend, int divisor) {
        String[] digits = Integer.toString(dividend).split("");
        String tempDividend = digits[0];
        int x = 0;

        while (x < digits.length - 1) {
            for (int i = 0; i <= digits.length - 1; i++) {

                if (Integer.parseInt(tempDividend) / divisor == 0) {
                    tempDividend = tempDividend.concat(digits[x + 1]);
                    i--;
                    x++;
                } else {
                    answer = answer.concat(String.valueOf(Integer.parseInt(tempDividend) / divisor));
                    reminder = Integer.parseInt(tempDividend) % divisor;
                    tempDividend = String.valueOf(reminder);
                }
            }
        }

        result.tempDividend = tempDividend;
        result.result = answer;
        result.reminder = String.valueOf(reminder);
        return result;
    }
}
