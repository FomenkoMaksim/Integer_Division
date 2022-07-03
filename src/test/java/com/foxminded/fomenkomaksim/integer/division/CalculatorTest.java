package com.foxminded.fomenkomaksim.integer.division;

import com.foxminded.fomenkomaksim.integer.division.model.Result;
import com.foxminded.fomenkomaksim.integer.division.model.Step;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    Calculator calculator;

    @BeforeEach
    void initEach() {
        calculator = new Calculator();
    }


    @Test
    void divideBe0() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(1353, 0));
    }

    @Test
    void divide() {
        Result expected = new Result(338467, 11, 30769, 8, Arrays.asList(
                new Step(33, 33),
                new Step(84, 77),
                new Step(76, 66),
                new Step(107, 99)
        ));
        Result actual = calculator.divide(338467, 11);
        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    void checkNotNegativeNumbers() {
        Result expected = new Result(338467, 11, 30769, 8, Arrays.asList(
                new Step(33, 33),
                new Step(84, 77),
                new Step(76, 66),
                new Step(107, 99)
        ));

        boolean negative = false;

        if (expected.getDividend() < 0) {
            negative = true;
        } else if (expected.getDivisor() < 0) {
            negative = true;
        }

        assertFalse(negative);
    }
}