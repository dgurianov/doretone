package com.doretone.core;

import com.doretone.core.domain.Note;
import com.doretone.core.exceptions.InvalidNoteException;
import org.junit.Test;
import static org.junit.Assert.*;

public class LoopedNoteIteratorNewTest {


    @Test
    public void happyCase()throws InvalidNoteException{
        Note startNote = new Note('A','b');
        Note nextNoteExpected = new Note('A');
        LoopedNoteIteratorNew lni = new LoopedNoteIteratorNew(startNote);
        assertEquals(lni.next()[0],nextNoteExpected);
    }

    @Test
    public void loopTest() throws InvalidNoteException{
        Note startNote = new Note('A','b');
        Note nextNoteExpected = new Note('A');
        LoopedNoteIteratorNew lni = new LoopedNoteIteratorNew(startNote);
        for (int i = 0; i < 12; i++) {
            lni.next();
        }
        assertEquals(lni.next()[0],nextNoteExpected);
    }
}
