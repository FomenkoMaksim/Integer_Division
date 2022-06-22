package com.foxminded.fomenkomaksim.integer_division2;


import java.util.Formatter;

public class FormatterFactory extends Result {
    Formatter formatter = new Formatter();
    StringBuilder space = new StringBuilder("");

    public static String setDash(String str) {
        StringBuilder sb = new StringBuilder();
        String[] arrayStr = str.split("");


        sb.append("-".repeat(arrayStr.length));
        return sb.toString();
    }

    public String partOne(Result result) {
        StringBuilder sb = new StringBuilder();
        formatter.format("_%-5s|%s%n", result.dividend, result.divisor);
        formatter.format(" %-5s|" + "%s%n", result.stepsList.get(0).subtraction, setDash(result.quotient));
        formatter.format(" %-5s|" + "%s%n", setDash(result.stepsList.get(0).subtraction), result.quotient);
        for (int i = 1; i < result.stepsList.size(); i++) {
            formatter.format("%1$s_%2$-5s%n" + "%1$s %3$-5s%n" + "%1$s %4$-5s%n", space, result.stepsList.get(i).dividend, result.stepsList.get(i).subtraction, setDash(result.stepsList.get(i).subtraction));
            space.append(" ");
        }
        formatter.format("%s" + " %s", space, result.reminder);

        sb.append(formatter.toString());
        return sb.toString();
    }


}
