package com.foxminded.fomenkomaksim.integer_division2;

public class Calculator {
    Result result = new Result();
    Step steps;

    private String answer = "";
    private String reminder = "";

    public Result divide(int dividend, int divisor) {
        String[] digits = Integer.toString(dividend).split("");
        String tempDividend = digits[0];
        int x = 0;

        while (x < digits.length - 1) {

            for (int i = 0; i <= digits.length - 1; i++) {

                if (Integer.parseInt(tempDividend) / divisor == 0) {
                    if (x + 1 >= digits.length) {
                        break;
                    }
                    tempDividend = tempDividend.concat(digits[x + 1]);
                    i--;
                    x++;
                } else {
                    answer = answer.concat(String.valueOf(Integer.parseInt(tempDividend) / divisor));
                    reminder = String.valueOf(Integer.parseInt(tempDividend) % divisor);
                    String subtraction = String.valueOf(Integer.parseInt(tempDividend) - Integer.parseInt(reminder));

                    steps = new Step(tempDividend, subtraction);
                    result.stepsList.add(steps);
                    tempDividend = String.valueOf(reminder);
                }
            }
        }

        result.quotient = answer;
        result.reminder = String.valueOf(reminder);
        return result;
    }
}
