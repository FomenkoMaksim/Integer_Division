package com.foxminded.fomenkomaksim.integer.division;

public class Step {
    private final int dividend;
    private final int subtraction;

    public Step(int dividend, int subtraction) {
        this.dividend = dividend;
        this.subtraction = subtraction;
    }

    public int getDividend() {
        return dividend;
    }

    public int getSubtraction() {
        return subtraction;
    }
}
