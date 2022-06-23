package com.foxminded.fomenkomaksim.integer.division;


import java.util.Formatter;

public interface ResultFormatter{
    Formatter formatter = new Formatter();
    StringBuilder space = new StringBuilder();

    static String setDash(String str) {
        StringBuilder sb = new StringBuilder();
        String[] arrayStr = str.split("");

        sb.append("-".repeat(arrayStr.length));
        return sb.toString();
    }

    static String partOne(Result result) {
        StringBuilder sb = new StringBuilder();
        formatter.format("_%-5s|%s%n", result.getResultDividend(), result.getResultDivisor());
        formatter.format(" %-5s|" + "%s%n", result.getStepsList().get(0).subtraction, setDash(String.valueOf(result.getQuotient())));
        formatter.format(" %-5s|" + "%s%n", setDash(String.valueOf(result.getStepsList().get(0).subtraction)), result.getQuotient());
        for (int i = 1; i < result.getStepsList().size(); i++) {
            formatter.format("%1$s_%2$-5s%n" + "%1$s %3$-5s%n" + "%1$s %4$-5s%n", space, result.getStepsList().get(i).dividend, result.getStepsList().get(i).subtraction, setDash(String.valueOf(result.getStepsList().get(i).subtraction)));
            space.append(" ");
        }
        formatter.format("%s" + " %s", space, result.getReminder());

        sb.append(formatter);
        return sb.toString();
    }
}
