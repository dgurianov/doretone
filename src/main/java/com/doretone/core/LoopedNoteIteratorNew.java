package com.doretone.core;

import com.doretone.core.domain.Note;
import com.doretone.core.exceptions.InvalidNoteException;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Iterator;

@Slf4j
public class LoopedNoteIteratorNew implements Iterator<Note[]> {

    private Note[][] container = new Note[12][2];
    private int currentIndex = 0;

    public LoopedNoteIteratorNew(Note startNote) throws InvalidNoteException {
        fillTheContainer();
        this.currentIndex = getNoteIndex(startNote) - 1; //Step back one semitone , so next() will do ++ and  return actual start note
        log.debug("Initiated new iterator with start note {}",startNote);
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Note[] next() {
        if(this.currentIndex == container.length-1){
            this.currentIndex = 0;

        }else{
            this.currentIndex++;
        }
        log.debug("Next note(s) {}",container[this.currentIndex][0]);
        return container[this.currentIndex];
    }
    public Note[] getNextWithInterval(Note startNote, int interval) throws InvalidNoteException{
        this.currentIndex = getNoteIndex(startNote);
        return container[this.currentIndex+interval];
    }

    private int getNoteIndex(Note note) throws InvalidNoteException{
        for (int i = 0; i <container.length ; i++) {
            if(Arrays.asList(container[i]).contains(note)) return i;
        }
        throw new InvalidNoteException("Note provided in constructor does not exist.");
    }

    public String nextToString(){
        return notePairToString(next());
    }

    private String notePairToString(Note[] pair){
        if(pair.length > 1){
            return pair[0] + "/" + pair[1];
        }
        return pair[0].toString();

    }

    private void fillTheContainer(){
        container[0] = new Note[]{ new Note('C') };
        container[1] = new Note[]{ new Note('C','#'), new Note('D','b') };
        container[2] = new Note[]{ new Note('D') };
        container[3] = new Note[]{ new Note('D','#'), new Note('E','b') };
        container[4] = new Note[]{ new Note('E') };
        container[5] = new Note[]{ new Note('F') };
        container[6] = new Note[]{ new Note('F','#'), new Note('G','b') };
        container[7] = new Note[]{ new Note('G') };
        container[8] = new Note[]{ new Note('G','#'), new Note('A','b') };
        container[9] = new Note[]{ new Note('A') };
        container[10] = new Note[]{ new Note('A','#'), new Note('H','b') };
        container[11] = new Note[]{ new Note('H') };
    }


}
