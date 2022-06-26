package com.foxminded.fomenkomaksim.integer.division;

import com.foxminded.fomenkomaksim.integer.division.formatter.Formatter;
import com.foxminded.fomenkomaksim.integer.division.formatter.FormatterFactory;
import com.foxminded.fomenkomaksim.integer.division.model.Result;

public class IntegerDivisionApp {
    static final int DIVIDEND = 657;
    static final int DIVISOR = 4;

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Result result = calculator.divide(DIVIDEND, DIVISOR);
        Formatter formatter = FormatterFactory.INSTANCE.get("germany");
        String output = formatter.format(result);
        System.out.print(output);
    }
}
