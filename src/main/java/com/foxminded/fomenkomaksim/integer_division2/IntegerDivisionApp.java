package com.foxminded.fomenkomaksim.integer_division2;

public class IntegerDivisionApp {
    static final int DIVIDEND = 78945;
    static final int DIVISOR = 4;

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Result result = calculator.divide(DIVIDEND, DIVISOR);
//        Formatter formatter = FormatterFactory.getInstance().get("classic");
//        String output = formatter.format(result);
        System.out.println("Результат " + result.quotient);
        System.out.println("Остаток " + result.reminder);
        System.out.println("Шаги " + result.stepsList);
    }
}
