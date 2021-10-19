package com.doretone.core.domain;

public enum ModeTemplates {

    //1 - One semitone  - Half (H)
    //2 - Two semitones - Whole tone (W)

    IONIAN("Ionian", new int[]{2,2,1,2,2,2,1}),         //W W H W W W H
    DORIAN("Dorian", new int[]{2,1,2,2,2,1,2}),          // W H W W W H W
    PHRYGIAN("Phrygian", new int[]{1,2,2,2,1,2,2}),        // H W W W H W W
    LYDIAN("Lydian", new int[]{2,2,2,1,2,2,1}),              // W W W H W W H
    MIXOLYDIAN("Mixolydian", new int[]{2,2,1,2,2,1,2}),       //  W W H W W H W
    AEOLIAN("Aeolian", new int[]{2,1,2,2,1,2,2}),               //  W H W W H W W
    LOCRIAN("Locrian", new int[]{1,2,2,1,2,2,2}),                //   H W W H W W W
    ;

    private int[] template;
    private String name;

    ModeTemplates(String name , int[] template){
        this.name = name;
        this.template = template;
    }

    public int[] getTemplate() {
        return template;
    }

    public String getName() {
        return name;
    }
}
