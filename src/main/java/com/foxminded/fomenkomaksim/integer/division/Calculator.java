package com.foxminded.fomenkomaksim.integer.division;

import com.foxminded.fomenkomaksim.integer.division.model.Result;
import com.foxminded.fomenkomaksim.integer.division.model.Step;

import java.util.ArrayList;
import java.util.List;

import static com.foxminded.fomenkomaksim.integer.division.misc.MathUtils.toDigits;

public class Calculator {
    public Result divide(int dividend, int divisor) {
        int minuend = 0;
        List<Step> steps = new ArrayList<>();
        for (int digit : toDigits(dividend)) {
            minuend = minuend * 10 + digit;
            if (minuend >= divisor) {
                int subtrahend = minuend / divisor * divisor;
                steps.add(new Step(minuend, subtrahend));
                minuend = minuend - subtrahend;
            }
        }
        return new Result(dividend, divisor, dividend / divisor, minuend, steps);
    }
}
