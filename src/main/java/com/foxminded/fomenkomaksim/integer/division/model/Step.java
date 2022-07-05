package com.foxminded.fomenkomaksim.integer.division.model;

import java.util.Objects;

public class Step {
    private final int minuend;
    private final int subtraction;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Step step = (Step) o;
        return minuend == step.minuend && subtraction == step.subtraction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(minuend, subtraction);
    }

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
