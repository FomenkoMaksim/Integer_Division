package com.foxminded.fomenkomaksim.integer.division.formatter;


import com.foxminded.fomenkomaksim.integer.division.model.Result;
import com.foxminded.fomenkomaksim.integer.division.model.Step;

import static com.foxminded.fomenkomaksim.integer.division.misc.MathUtils.length;
import static com.foxminded.fomenkomaksim.integer.division.misc.StringUtils.dashLine;
import static com.foxminded.fomenkomaksim.integer.division.misc.StringUtils.spacer;

public class ClassicFormatter implements Formatter {
    private int offset;

    @Override
    public String format(Result result) {
        StringBuilder sb = new StringBuilder();
        renderFirstPart(sb, result);

        for (int i = 1; i < result.getSteps().size(); i++) {
            Step current = result.getSteps().get(i);
            renderSecondPart(sb, current);
        }
        renderFinalPart(sb, result.getReminder());
        return sb.toString();
    }

    private void renderFirstPart(StringBuilder sb, Result result) {
        int lengthMinuend = length(result.getDividend());
        int lengthSubtraction = length(result.getSteps().get(0).getSubtraction());
        int diff = length(result.getSteps().get(0).getMinuend()) - length(result.getSteps().get(0).getSubtraction());

        sb.append("_").append(result.getDividend()).append("|").append(result.getDivisor()).append("\n");
        offset += length(result.getSteps().get(0).getMinuend()) - length(result.getSteps().get(0).getSubtraction()) + 1;

        sb.append(spacer(offset)).append(result.getSteps().get(0).getSubtraction())
                .append(spacer(lengthMinuend - lengthSubtraction - diff))
                .append("|").append(dashLine(length(result.getQuotient()))).append("\n");

        sb.append(spacer(offset)).append(dashLine(length(result.getSteps().get(0).getSubtraction())))
                .append(spacer(lengthMinuend - lengthSubtraction - diff)).append("|").append(result.getQuotient()).append("\n");
//        offset += length(result.getSteps().get(0).getMinuend() - result.getSteps().get(0).getSubtraction()) - 1;

        if (result.getSteps().get(0).getMinuend() - result.getSteps().get(0).getSubtraction() == 0) {
            offset += length(result.getSteps().get(0).getSubtraction()) - 1;
        } else if (length(result.getSteps().get(0).getMinuend() - result.getSteps().get(0).getSubtraction()) == length(result.getSteps().get(0).getSubtraction())) {
            offset--;
        }
    }

    private void renderSecondPart(StringBuilder sb, Step current) {
        sb.append(spacer(offset)).append("_").append(current.getMinuend()).append("\n");
        offset += 1;
        if (length(current.getMinuend()) - length(current.getSubtraction()) > 0) {
            offset += length(current.getMinuend()) - length(current.getSubtraction());
        }
        sb.append(spacer(offset)).append(current.getSubtraction()).append("\n");
        sb.append(spacer(offset)).append(dashLine(length(current.getSubtraction()))).append("\n");
        if (current.getMinuend() - current.getSubtraction() == 0) {
            offset += length(current.getSubtraction()) - 1;
        } else if (length(current.getMinuend() - current.getSubtraction()) == length(current.getSubtraction())) {
            offset--;
        }
    }

    private void renderFinalPart(StringBuilder sb, int reminder) {
        offset++;
        sb.append(spacer(offset)).append(reminder);
    }


//    StringBuilder sb = new StringBuilder();
//    StringBuilder space = new StringBuilder("");
//    java.util.Formatter formatter = new java.util.Formatter();
//
//    @Override
//    public String format(Result result) {
//        formatter.format("_%s" + "|" + "%s%n", result.getDividend(), result.getDivisor());
//        formatter.format(" %s" + "%-6s" + "|%s%n", space, result.getSteps().get(0).getSubtraction(), dashLine(length(result.getQuotient())));
//        formatter.format(" %s" + "%-6s" + "|%s%n", space, dashLine(length(result.getSteps().get(0).getMinuend())), result.getQuotient());
//        for(int i = 1; i < result.getSteps().size(); i++) {
//            if (result.getSteps().get(i-1).getMinuend() - result.getSteps().get(i-1).getSubtraction() == 0) {
//                space.append(spacer(length(result.getSteps().get(i-1).getMinuend())));
//            }
//            space.append(spacer(length(result.getReminder())));
//            formatter.format("%s" + "_%s%n", space, result.getSteps().get(i).getMinuend());
//            formatter.format(" %s" + "%s%n", space, result.getSteps().get(i).getSubtraction());
//            formatter.format(" %s" + "%s%n", space, dashLine(length(result.getSteps().get(i).getMinuend())));
//        }
//        space.append(spacer(length(result.getReminder())));
//        formatter.format("%s" + "%s", space, result.getReminder());
//        sb.append(formatter);
//        return sb.toString();
//    }

//    @Override
//    public String format(Result result) {
//        StringBuilder spacer = new StringBuilder(" ");
//        StringBuilder sb = new StringBuilder();
//        final java.util.Formatter formatter = new java.util.Formatter();
//
//        formatter.format("_%-5s|%s%n", result.getDividend(), result.getDivisor());
//        formatter.format("%s" + "%-5s|" + "%s%n",spacer, result.getSteps().get(0).getSubtraction(), dashLine(length(result.getQuotient())));
//        formatter.format(" %-5s|" + "%s%n", dashLine(length(result.getSteps().get(0).getSubtraction())), result.getQuotient());
//        for (int i = 1; i < result.getSteps().size(); i++) {
//            formatter.format("%1$s_%2$-5s%n" + "%1$s %3$-5s%n" + "%1$s %4$-5s%n", spacer,
//                    result.getSteps().get(i).getMinuend(), result.getSteps().get(i).getSubtraction(),
//                    dashLine(length(result.getSteps().get(i).getSubtraction())));
//            spacer.append(" ");
//        }
//        formatter.format("%s" + " %s%n", spacer, result.getReminder());
//
//        sb.append(formatter);
//        return sb.toString();
//    }
}
