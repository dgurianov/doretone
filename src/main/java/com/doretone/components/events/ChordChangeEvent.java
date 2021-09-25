package com.doretone.components.events;

import java.util.EventObject;

public class ChordChangeEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */

    private String chord;

    public ChordChangeEvent(Object source, String chord) {
        super(source);
        this.chord = chord;
    }

    public String getChord() {
        return chord;
    }
}
