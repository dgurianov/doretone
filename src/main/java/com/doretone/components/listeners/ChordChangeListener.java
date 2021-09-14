package com.doretone.components.listeners;

import com.doretone.components.events.ChordChangeEvent;

import java.util.EventListener;

public interface ChordChangeListener extends EventListener{
    public void chordChangeOccurred(ChordChangeEvent event );
}
