package com.doretone.components.notesneck;

import com.doretone.core.exceptions.InvalidNoteException;

import java.util.Arrays;
import java.util.Iterator;

public class LoopedNoteIterator implements Iterator<String> {

    private final String[] container = new String[]{
            "C",       //0
            "C#/bD",   //1
            "D",       //2
            "D#/bE",   //3
            "E",       //4
            "F",       //5
            "F#/bG",   //6
            "G",       //7
            "G#/bA",   //8
            "A",       //9
            "A#/bH",   //10
            "H"};      //11
    private int currentPosition;

    public LoopedNoteIterator(String startNote) throws InvalidNoteException{
        int index = Arrays.asList(container).indexOf(startNote);
        if (index == -1){
            throw new InvalidNoteException("Note provided [{}] is not recognisable");
        }else{
            this.currentPosition = index;
        }
    }

    //This is looped Iterator, so hasNext is always true
    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public String next() {
        if(this.currentPosition == container.length){
            this.currentPosition = 0;
            return next();
//            return container[currentPosition];
        }
        this.currentPosition++;//Move to next
        return container[currentPosition-1];// Return one before roll forward

    }


}
