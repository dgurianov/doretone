package com.doretone.components.intervallegendtable.constants;

import java.awt.*;

public enum IntervalLegendColor {
    GRAY(Color.lightGray),
    DEFAULT(Color.white),
    TONICA(new Color(255, 153, 153)),//#ff9999
    MINOR3(new Color(153, 255, 204)),//#99ffcc
    MAJOR3(new Color(204, 255, 153)),//#ccff99
    PERFECT5(new Color(255, 204, 153)),//#ffcc99
    MINOR7(new Color(153, 204, 255)),//#99ccff
    MAJOR7(new Color(255, 153, 255)),
    ;
    private Color value;

    IntervalLegendColor(Color value) {
        this.value = value;
    }

    public Color getValue() {
        return value;
    }
}
