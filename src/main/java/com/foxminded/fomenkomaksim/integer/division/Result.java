package com.foxminded.fomenkomaksim.integer.division;

import java.util.ArrayList;
import java.util.List;


public class Result {
    private static final int RESULT_DIVIDEND = IntegerDivisionApp.DIVIDEND;
    private static final int RESULT_DIVISOR = IntegerDivisionApp.DIVISOR;
    private int reminder;
    private int quotient;

    public void setReminder(int reminder) {
        this.reminder = reminder;
    }

    public void setQuotient(int quotient) {
        this.quotient = quotient;
    }

    public int getResultDividend() {
        return RESULT_DIVIDEND;
    }

    public int getResultDivisor() {
        return RESULT_DIVISOR;
    }

    public int getReminder() {
        return reminder;
    }

    public int getQuotient() {
        return quotient;
    }

    public List<Step> getStepsList() {
        return stepsList;
    }

    private final List<Step> stepsList = new ArrayList<>();

}
