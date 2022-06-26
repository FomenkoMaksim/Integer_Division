package com.foxminded.fomenkomaksim.integer.division.formatter;

import com.foxminded.fomenkomaksim.integer.division.model.Result;

import static com.foxminded.fomenkomaksim.integer.division.misc.MathUtils.length;
import static com.foxminded.fomenkomaksim.integer.division.misc.StringUtils.dashLine;

public class GermanyFormatter implements Formatter {

    @Override
    public String format(Result result) {
        StringBuilder spacer = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        final java.util.Formatter formatter = new java.util.Formatter();

        formatter.format("%s ÷ %s => %s%n", result.getDividend(), result.getDivisor(), result.getQuotient());
        formatter.format("%s%n" + "%s%n", result.getSteps().get(0).getSubtraction(), dashLine(length(result.getSteps().get(0).getSubtraction())));
        for (int i = 1; i < result.getSteps().size(); i++) {
            formatter.format("%s" + "%s%n", spacer, result.getSteps().get(i).getMinuend());
            formatter.format("%s" + "%s%n", spacer, result.getSteps().get(i).getSubtraction());
            formatter.format("%s" + "%s%n", spacer, dashLine(length(result.getSteps().get(i).getMinuend())));
            spacer.append(" ");
        }
        formatter.format("%s" + "%s", spacer, result.getReminder());

        sb.append(formatter);
        return sb.toString();
    }
}
