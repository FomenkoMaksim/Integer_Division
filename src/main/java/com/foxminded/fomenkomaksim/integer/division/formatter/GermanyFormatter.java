package com.foxminded.fomenkomaksim.integer.division.formatter;

import com.foxminded.fomenkomaksim.integer.division.model.Result;
import com.foxminded.fomenkomaksim.integer.division.model.Step;

import static com.foxminded.fomenkomaksim.integer.division.misc.MathUtils.length;
import static com.foxminded.fomenkomaksim.integer.division.misc.StringUtils.dashLine;
import static com.foxminded.fomenkomaksim.integer.division.misc.StringUtils.spacer;

public class GermanyFormatter implements Formatter {
    private final StringBuilder sb = new StringBuilder();

    @Override
    public String format(Result result) {
        int offset;
        offset = renderFirstPart(result);

        for (int i = 1; i < result.getSteps().size(); i++) {
            Step current = result.getSteps().get(i);
            offset = renderSecondPart(current, offset);
        }
        renderFinalPart(result, result.getReminder());

        return sb.toString();
    }

    private int renderFirstPart(Result result) {
        int offset = 0;
        sb.append(result.getDividend()).append(" ÷ ").append(result.getDivisor())
                .append(" => ").append(result.getQuotient()).append('\n');
        offset += length(result.getSteps().get(0).getMinuend()) - length(result.getSteps().get(0).getSubtraction());
        sb.append(spacer(offset)).append(result.getSteps().get(0).getSubtraction()).append('\n');
        sb.append(spacer(offset)).append(dashLine(length(result.getSteps().get(0).getSubtraction()))).append('\n');

        if (result.getSteps().get(0).getMinuend() - result.getSteps().get(0).getSubtraction() == 0) {
            offset = length(result.getSteps().get(0).getSubtraction());
        } else {
            offset += length(result.getSteps().get(0).getSubtraction()) - length(result.getSteps().get(0).getMinuend() - result.getSteps().get(0).getSubtraction());
        }
        return offset;
    }

    private int renderSecondPart(Step current, int offset) {
        int lengthMinuend = length(current.getMinuend());
        int lengthSubtraction = length(current.getSubtraction());

        sb.append(spacer(offset)).append(current.getMinuend()).append('\n');
        offset += lengthMinuend - lengthSubtraction;
        sb.append(spacer(offset)).append(current.getSubtraction()).append('\n');
        sb.append(spacer(offset)).append(dashLine(length(current.getSubtraction()))).append('\n');

        if (current.getMinuend() - current.getSubtraction() == 0) {
            offset = length(current.getSubtraction());
        } else {
            offset += length(current.getSubtraction()) - length(current.getMinuend() - current.getSubtraction());
        }
        return offset;
    }

    private void renderFinalPart(Result result, int reminder) {
        int offset = length(result.getDividend()) - length(reminder);
        sb.append(spacer(offset)).append(reminder);
    }
}
