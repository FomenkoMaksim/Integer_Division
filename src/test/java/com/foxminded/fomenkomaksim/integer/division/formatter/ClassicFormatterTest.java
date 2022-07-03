package com.foxminded.fomenkomaksim.integer.division.formatter;

import com.foxminded.fomenkomaksim.integer.division.model.Result;
import com.foxminded.fomenkomaksim.integer.division.model.Step;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ClassicFormatterTest {

    @Test
    void classicFormat() {
        Result result = new Result(338467, 11, 30769, 8, Arrays.asList(
                new Step(33, 33),
                new Step(84, 77),
                new Step(76, 66),
                new Step(107, 99)
        ));
        Formatter classicFormatter = FormatterFactory.INSTANCE.get("classic");
        String expected =
                "_338467|11" + '\n' +
                        " 33    |-----" + '\n' +
                        " --    |30769" + '\n' +
                        "  _84" + '\n' +
                        "   77" + '\n' +
                        "   --" + '\n' +
                        "   _76" + '\n' +
                        "    66" + '\n' +
                        "    --" + '\n' +
                        "   _107" + '\n' +
                        "     99" + '\n' +
                        "     --" + '\n' +
                        "      8";
        assertEquals(expected, classicFormatter.format(result));
    }

    @Test
    void classicFormat2() {
        Result result = new Result(78945, 4, 19736, 1, Arrays.asList(
                new Step(7, 4),
                new Step(38, 36),
                new Step(29, 28),
                new Step(14, 12),
                new Step(25, 24)
        ));
        Formatter classicFormatter = FormatterFactory.INSTANCE.get("classic");
        String expected =
                "_78945|4" + '\n' +
                " 4    |-----" + '\n' +
                " -    |19736" + '\n' +
                "_38" + '\n' +
                " 36" + '\n' +
                " --" + '\n' +
                " _29" + '\n' +
                "  28" + '\n' +
                "  --" + '\n' +
                "  _14" + '\n' +
                "   12" + '\n' +
                "   --" + '\n' +
                "   _25" + '\n' +
                "    24" + '\n' +
                "    --" + '\n' +
                "     1";
        assertEquals(expected, classicFormatter.format(result));
    }

    @Test
    void notNullResult() {
        Result result = new Result(78945, 4, 19736, 1, Arrays.asList(
                new Step(7, 4),
                new Step(38, 36),
                new Step(29, 28),
                new Step(14, 12),
                new Step(25, 24)
        ));
        Formatter classicFormatter = FormatterFactory.INSTANCE.get("classic");

        assertNotNull(classicFormatter.format(result));
    }
}