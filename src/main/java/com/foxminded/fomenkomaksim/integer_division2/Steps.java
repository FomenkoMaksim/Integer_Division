package com.foxminded.fomenkomaksim.integer_division2;

public class Steps {

    String dividend;
    String closerNumber;

    public Steps(String dividend, String closerNumber) {
        this.dividend = dividend;
        this.closerNumber = closerNumber;
    }

    @Override
    public String toString() {
        return dividend + "--" + closerNumber;
    }
}
