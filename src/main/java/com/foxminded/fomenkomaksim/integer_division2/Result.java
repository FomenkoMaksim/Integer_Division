package com.foxminded.fomenkomaksim.integer_division2;

import java.util.ArrayList;
import java.util.List;

public class Result {
    public String reminder;
    public String quotient;
//    public String tempDividend;
    List<Steps> stepsList = new ArrayList<>();

    @Override
    public String toString() {
        return String.valueOf(quotient);
    }
}
