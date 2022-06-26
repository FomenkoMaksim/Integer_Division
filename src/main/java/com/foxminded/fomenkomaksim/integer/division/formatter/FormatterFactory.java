package com.foxminded.fomenkomaksim.integer.division.formatter;

import java.util.Locale;

public enum FormatterFactory {
    INSTANCE;

    public Formatter get(String name) {
        switch (name.toLowerCase(Locale.ROOT)) {
            case "classic":
                return new ClassicFormatter();
            default:
                throw new IllegalArgumentException("Formatter of name " + name + " not implemented yet");
        }
    }
}
