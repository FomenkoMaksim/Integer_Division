package com.foxminded.fomenkomaksim.integer.division.formatter;


import com.foxminded.fomenkomaksim.integer.division.model.Result;

import static com.foxminded.fomenkomaksim.integer.division.misc.MathUtils.length;
import static com.foxminded.fomenkomaksim.integer.division.misc.StringUtils.dashLine;

public class ClassicFormatter implements Formatter {
    @Override
    public String format(Result result) {
        StringBuilder spacer = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        final java.util.Formatter formatter = new java.util.Formatter();

        formatter.format("_%-5s|%s%n", result.getDividend(), result.getDivisor());
        formatter.format(" %-5s|" + "%s%n", result.getSteps().get(0).getSubtraction(), dashLine(length(result.getQuotient())));
        formatter.format(" %-5s|" + "%s%n", dashLine(length(result.getSteps().get(0).getSubtraction())), result.getQuotient());
        for (int i = 1; i < result.getSteps().size(); i++) {
            formatter.format("%1$s_%2$-5s%n" + "%1$s %3$-5s%n" + "%1$s %4$-5s%n", spacer, result.getSteps().get(i).getMinuend(), result.getSteps().get(i).getSubtraction(), dashLine(length(result.getSteps().get(i).getSubtraction())));
            spacer.append(" ");
        }
        formatter.format("%s" + " %s%n", spacer, result.getReminder());

        sb.append(formatter);
        return sb.toString();
    }
}
