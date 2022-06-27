package com.foxminded.fomenkomaksim.integer.division.model;

public class Step {
    private final int minuend;
    private final int subtraction;

    public Step(int minuend, int subtraction) {
        this.minuend = minuend;
        this.subtraction = subtraction;
    }

    public int getMinuend() {
        return minuend;
    }

    public int getSubtraction() {
        return subtraction;
    }

}
