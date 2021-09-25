package com.doretone.components.intervallegendtable.constants;


public enum IntervalLegendColumnWidth {
    SEMITONES(75),
    ROMAN(75),
    ARABIC(75),
    RUS(310),
    ENG(200),
    SYMBOLS(75),
    ;


    IntervalLegendColumnWidth(int value) {
        this.value = value;
    }

    private int value;

    public int getValue() {
        return value;
    }
}
