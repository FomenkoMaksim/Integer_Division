package com.foxminded.fomenkomaksim.integer.division;

public class IntegerDivisionApp {
    static final int DIVIDEND = 78945;
    static final int DIVISOR = 25;

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Result result = calculator.divide(DIVIDEND, DIVISOR);

        System.out.print(ResultFormatter.partOne(result));
    }
}
