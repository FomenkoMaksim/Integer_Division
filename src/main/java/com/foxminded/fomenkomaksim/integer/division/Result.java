package com.foxminded.fomenkomaksim.integer.division;

import java.util.Collections;
import java.util.List;

public class Result {
    private final int resultDividend;
    private final int resultDivisor;
    private final int resultReminder;
    private final int resultQuotient;
    private final List<Step> steps;

    public Result(int resultDividend, int resultDivisor, int resultReminder, int resultQuotient, List<Step> steps) {
        this.resultDividend = resultDividend;
        this.resultDivisor = resultDivisor;
        this.resultReminder = resultReminder;
        this.resultQuotient = resultQuotient;
        this.steps = Collections.unmodifiableList(steps);
    }

    public int getResultDividend() {
        return resultDividend;
    }

    public int getResultDivisor() {
        return resultDivisor;
    }

    public int getResultReminder() {
        return resultReminder;
    }

    public int getResultQuotient() {
        return resultQuotient;
    }

    public List<Step> getSteps() {
        return steps;
    }



}
