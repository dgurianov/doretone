package com.doretone.core.domain;

import java.util.ArrayList;

public class Mode {
    private Note note;
    private boolean minor;
    private String name;
    private String nameShort;
    private ArrayList<Note> notes;
    private ModeTemplates template;

    public Mode(ModeTemplates mode , Note note , boolean minor) {
        this.note = note;
        this.minor = minor;
        this.template = mode;
    }
}
