package com.foxminded.fomenkomaksim.integer.division.formatter;

import com.foxminded.fomenkomaksim.integer.division.model.Result;
import com.foxminded.fomenkomaksim.integer.division.model.Step;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GermanyFormatterTest {

    @Test
    void germanyFormat() {
        Result result = new Result(224512, 22, 10205, 2, Arrays.asList(
                new Step(22, 22),
                new Step(45, 44),
                new Step(112, 110)
        ));
        Formatter germanyFormatter = FormatterFactory.INSTANCE.get("germany");
        String expected = "224512 ÷ 22 => 10205" + '\n' +
                "22" + '\n' +
                "--" + '\n' +
                "  45" + '\n' +
                "  44" + '\n' +
                "  --" + '\n' +
                "   112" + '\n' +
                "   110" + '\n' +
                "   ---" + '\n' +
                "     2";
        assertEquals(expected, germanyFormatter.format(result));
    }

    @Test
    void germanyFormat2() {
        Result result = new Result(338467, 11, 30769, 8, Arrays.asList(
                new Step(33, 33),
                new Step(84, 77),
                new Step(76, 66),
                new Step(107, 99)
        ));
        Formatter germanyFormatter = FormatterFactory.INSTANCE.get("germany");
        String expected = "338467 ÷ 11 => 30769" + '\n' +
                "33" + '\n' +
                "--" + '\n' +
                "  84" + '\n' +
                "  77" + '\n' +
                "  --" + '\n' +
                "   76" + '\n' +
                "   66" + '\n' +
                "   --" + '\n' +
                "   107" + '\n' +
                "    99" + '\n' +
                "    --" + '\n' +
                "     8";

        assertEquals(expected, germanyFormatter.format(result));
    }

    @Test
    void notNullResult() {
        Result result = new Result(338467, 11, 30769, 8, Arrays.asList(
                new Step(33, 33),
                new Step(84, 77),
                new Step(76, 66),
                new Step(107, 99)
        ));

        Formatter germanyFormatter = FormatterFactory.INSTANCE.get("germany");

        assertNotNull(germanyFormatter.format(result));
    }
}