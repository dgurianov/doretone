package com.doretone.core.domain;

import java.util.ArrayList;

public class Chord {
    private String name;
    private boolean flat;
    private boolean sharp;
    private ArrayList<Note> notes;


    public Chord(String name, ArrayList<Note> notes) {
        this(name,notes,' ');
    }

//TODO: finish or remove
//    public Chord(String name, Character[] notesArray ,Character sharpOrFlat ) {
//        for (int i = 0; i < notesArray.length; i++) {
//            notes.add(new)
//        }
//    }
//
//    public Chord(String name, Character[] notesArray) {
//        this(name,notesArray,' ');
//    }

    public Chord(String name, ArrayList<Note> notes, Character sharpOrFlat) {
        this.name = capitalizeChord(name);
        this.notes = notes;
        if(sharpOrFlat.compareTo(' ') == 0){
            this.sharp = false;
            this.flat = false;
        }else if (sharpOrFlat.compareTo('#')== 0){
            this.sharp = true;
            this.flat = false;
        }else if (sharpOrFlat.compareTo('b')== 0){
            this.flat = true;
            this.sharp = false;
        }
    }

    private String capitalizeChord(String chord){
       return Character.toUpperCase(chord.charAt(0)) + chord.substring(1);
    }

    @Override
    public String toString() {
        if(this.sharp && !this.flat){
            return name+"#";
        }else if (this.flat && !this.sharp){
            return name+"b";
        }
        return name;
    }


    public String toStringNotes(){
        return String.format("T: %s  D: %s  S: %s",
                notes.get(0),
                notes.get(1),
                notes.get(2));
    }
}
