package com.doretone.core.domain;

import java.awt.*;

public enum Intervals {
    TONICA(0,new Color(255, 153, 153)), //#ff9999),
    MINOR_SECOND(1,Color.white),
    MAJOR_SECOND(2,Color.white),
    MINOR_THIRD(3,new Color(153, 255, 204)),//#99ffcc),
    MAJOR_THIRD(4,new Color(204, 255, 153)),//#ccff99),
    PERFECT_FOURTH(5,Color.white),
    AUGMENTED_FOURTH(6,Color.white),
    PERFECT_FIFTH(7,new Color(255, 204, 153)),//#ffcc99),
    MINOR_SIXTH(8,Color.white),
    MAJOR_SIXTH(9,Color.white),
    MINOR_SEVENTH(10,new Color(153, 204, 255)),//#99ccff),
    MAJOR_SEVENTH(11,new Color(255, 153, 255)),
    NONE(100,Color.white) //Used to  get color when no TONICA is defiled yet, like application start.
    ;
    private int length;
    private Color color;

    Intervals(int length, Color color) {
        this.length = length;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public int getLength() {
        return length;
    }

}
