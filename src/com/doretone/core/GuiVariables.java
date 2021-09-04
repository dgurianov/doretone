package com.doretone.core;

public enum GuiVariables {
    //Global
    GLB_EMPTY(""),
    GLB_APP_VERSION("1.0.0"),

    //Main window
    MAIN_FRAME_HEADER_MESSAGE("Do Re Tone guitar helper"),

    //Chord randomizer
    CHORD_RND_LABEL_TIME_INTERVAL("Time interval : "),
    CHORD_RND_BUTTON_START("Generate"),
    CHORD_RND_BUTTON_STOP("Stop"),
    CHORD_RND_BORDER_FORM_PANEL("Generate random chord"),
    CHORD_RND_BORDER_CHORD_PANEL("Generated chord"),
    CHORD_RND_LABEL_NO_CHORD("No chord");


    private String value;


    GuiVariables(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
