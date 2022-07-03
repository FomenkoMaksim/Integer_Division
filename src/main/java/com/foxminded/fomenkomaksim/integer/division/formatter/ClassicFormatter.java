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
        renderFinalPart(sb, result.getReminder(), result);
        return sb.toString();
    }

    private void renderFirstPart(StringBuilder sb, Result result) {
        int lengthDividend = length(result.getDividend());
        int lengthSubtraction = length(result.getSteps().get(0).getSubtraction());
        int lengthDiff = length(result.getSteps().get(0).getMinuend()) - length(result.getSteps().get(0).getSubtraction());

        sb.append("_").append(result.getDividend()).append("|").append(result.getDivisor()).append('\n');
        offset += length(result.getSteps().get(0).getMinuend()) - length(result.getSteps().get(0).getSubtraction()) + 1;

        sb.append(spacer(offset)).append(result.getSteps().get(0).getSubtraction())
                .append(spacer(lengthDividend - lengthSubtraction - lengthDiff))
                .append("|").append(dashLine(length(result.getQuotient()))).append('\n');

        sb.append(spacer(offset)).append(dashLine(length(result.getSteps().get(0).getSubtraction())))
                .append(spacer(lengthDividend - lengthSubtraction - lengthDiff)).append("|").append(result.getQuotient()).append('\n');

        if (result.getSteps().get(0).getMinuend() - result.getSteps().get(0).getSubtraction() == 0) {
            offset = length(result.getSteps().get(0).getSubtraction());
        } else if (length(result.getSteps().get(0).getMinuend() - result.getSteps().get(0).getSubtraction()) == length(result.getSteps().get(0).getSubtraction())) {
            offset--;
        } else {
            offset += length(result.getSteps().get(0).getSubtraction()) - length(result.getSteps().get(0).getMinuend() - result.getSteps().get(0).getSubtraction()) - 1;
        }
    }

    private void renderSecondPart(StringBuilder sb, Step current) {
        sb.append(spacer(offset)).append("_").append(current.getMinuend()).append('\n');
        offset++;

        if (length(current.getMinuend()) - length(current.getSubtraction()) > 0) {
            offset += length(current.getMinuend()) - length(current.getSubtraction());
        }

        sb.append(spacer(offset)).append(current.getSubtraction()).append('\n');
        sb.append(spacer(offset)).append(dashLine(length(current.getSubtraction()))).append('\n');

        if (current.getMinuend() - current.getSubtraction() == 0) {
            offset += length(current.getSubtraction()) - 1;
        } else if (length(current.getMinuend() - current.getSubtraction()) == length(current.getSubtraction())) {
            offset--;
        }
    }

    private void renderFinalPart(StringBuilder sb, int reminder, Result result) {
        offset = 1 + length(result.getDividend()) - length(result.getReminder());
        sb.append(spacer(offset)).append(reminder);
    }
}