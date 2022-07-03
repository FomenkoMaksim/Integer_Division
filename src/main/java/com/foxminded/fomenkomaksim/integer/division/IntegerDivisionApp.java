package com.foxminded.fomenkomaksim.integer.division;

import com.foxminded.fomenkomaksim.integer.division.formatter.Formatter;
import com.foxminded.fomenkomaksim.integer.division.formatter.FormatterFactory;
import com.foxminded.fomenkomaksim.integer.division.model.Result;

public class IntegerDivisionApp {
    static final int DIVIDEND = 1234;
    static final int DIVISOR = 123;

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Result result = calculator.divide(DIVIDEND, DIVISOR);
        Formatter formatter = FormatterFactory.INSTANCE.get("classic");
        String output = formatter.format(result);
        System.out.print(output);
    }
}
