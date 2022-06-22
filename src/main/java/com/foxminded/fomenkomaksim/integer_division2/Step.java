package com.foxminded.fomenkomaksim.integer_division2;

public class Step {

    String dividend;
    String subtraction;

    public Step(String dividend, String subtraction) {
        this.dividend = dividend;
        this.subtraction = subtraction;
    }

    @Override
    public String toString() {
        return dividend + " " + subtraction;
    }
}
