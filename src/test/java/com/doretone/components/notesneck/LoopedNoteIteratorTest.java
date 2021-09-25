package com.doretone.components.notesneck;

import com.doretone.core.exceptions.InvalidNoteException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class LoopedNoteIteratorTest {

    private LoopedNoteIterator loopedNoteIterator;

    @Before
    public void setUp(){
    }

//    @Test
//    public void testCurrentNote() throws InvalidNoteException {
//        loopedNoteIterator = new LoopedNoteIterator("E");
//        assertEquals("Expected E ", loopedNoteIterator.current(),"E");
//    }

    @Test
    public void testNextNote() throws InvalidNoteException{
        loopedNoteIterator = new LoopedNoteIterator("E");
        assertEquals("Expected E ", loopedNoteIterator.next(),"E");
    }

    @Test(expected = InvalidNoteException.class)
    public void testInvalidNote() throws InvalidNoteException{
        loopedNoteIterator = new LoopedNoteIterator("X");
    }

    @Test
    public void testHasNextAlwaysReturnsTrue()throws InvalidNoteException{
        loopedNoteIterator = new LoopedNoteIterator("C");
        assertTrue(loopedNoteIterator.hasNext());
    }

}
