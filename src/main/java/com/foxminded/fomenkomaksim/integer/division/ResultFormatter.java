package com.foxminded.fomenkomaksim.integer.division;


import java.util.Formatter;

public class ResultFormatter implements com.foxminded.fomenkomaksim.integer.division.Formatter {
    Formatter formatter = new Formatter();
    StringBuilder space = new StringBuilder();

    static String setDash(int number) {
        StringBuilder sb = new StringBuilder();
        int length = (int) (Math.log10(number) + 1);
        sb.append("-".repeat(length));
        return sb.toString();
    }

    @Override
    public String format(Result result) {
        StringBuilder sb = new StringBuilder();
        formatter.format("_%-5s|%s%n", result.getResultDividend(), result.getResultDivisor());
        formatter.format(" %-5s|" + "%s%n", result.getSteps().get(0).getSubtraction(), setDash((result.getResultQuotient())));
        formatter.format(" %-5s|" + "%s%n", setDash(result.getSteps().get(0).getSubtraction()), result.getResultQuotient());
        for (int i = 1; i < result.getSteps().size(); i++) {
            formatter.format("%1$s_%2$-5s%n" + "%1$s %3$-5s%n" + "%1$s %4$-5s%n", space, result.getSteps().get(i).getDividend(), result.getSteps().get(i).getSubtraction(), setDash(result.getSteps().get(i).getSubtraction()));
            space.append(" ");
        }
        formatter.format("%s" + " %s", space, result.getResultReminder());

        sb.append(formatter);
        return sb.toString();    }
}
