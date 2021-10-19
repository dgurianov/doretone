package com.doretone.core.domain;

public class Note {

    private Character name;
    private boolean flat;
    private boolean sharp;


    public Note(Character name) {
        this(name,' ');
    }

    public Note(Character name, Character sharpOrFlat) {
        this.name = Character.toUpperCase(name);
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

    public Character getName() {
        return name;
    }

    public boolean isFlat() {
        return flat;
    }

    public boolean isSharp() {
        return sharp;
    }

    @Override
    public String toString() {
        if(this.sharp && !this.flat){
            return name+"#";
        }else if (this.flat && !this.sharp){
            return name+"b";
        }
        return name.toString() ;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Note){
            return this.toString().equalsIgnoreCase(obj.toString());
        }
        return false;
    }
}
