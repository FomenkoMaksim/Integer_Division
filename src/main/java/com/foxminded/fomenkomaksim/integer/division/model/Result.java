package com.foxminded.fomenkomaksim.integer.division.model;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Result {
    private final int dividend;
    private final int divisor;
    private final int quotient;
    private final int reminder;
    private final List<Step> steps;

    public Result(int dividend, int divisor, int quotient, int reminder, List<Step> steps) {
        this.dividend = dividend;
        this.divisor = divisor;
        this.quotient = quotient;
        this.reminder = reminder;
        this.steps = Collections.unmodifiableList(steps);
    }

    public int getDividend() {
        return dividend;
    }

    public int getDivisor() {
        return divisor;
    }

    public int getQuotient() {
        return quotient;
    }

    public int getReminder() {
        return reminder;
    }

    public List<Step> getSteps() {
        return steps;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return dividend == result.dividend && divisor == result.divisor && quotient == result.quotient && reminder == result.reminder && steps.equals(result.steps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dividend, divisor, quotient, reminder, steps);
    }
}
