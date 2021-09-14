package com.doretone.components.notesneck;

import com.doretone.core.exceptions.InvalidNoteException;

import java.util.HashMap;


public class NoteNeckContainer {

    private  HashMap<String,String[]> importantIntervalsMap ;
    private final String[][] container;
    private LoopedNoteIterator noteIterator;

    public NoteNeckContainer() {
        this.container = new String[7][12];
        try {
            populateContainer();
        }catch (InvalidNoteException e){
            //TODO: Log this one
            System.out.println(e.getLocalizedMessage());
        }
        populateImportantIntervalsMap();

    }

    private void populateContainer() throws InvalidNoteException {
        // array of fret numbers
        for(int fret = 0 ; fret < container[0].length ; fret++){
            container[0][fret] = String.valueOf(fret);
        }
        for(int string = 1 ; string < 7 ; string++ ){
            switch (string) {
                case 1:
                case 6:
                    this.noteIterator = new LoopedNoteIterator("E");
                    break;
                case 2:
                    this.noteIterator = new LoopedNoteIterator("H");
                    break;
                case 3:
                    this.noteIterator = new LoopedNoteIterator("G");
                    break;
                case 4:
                    this.noteIterator = new LoopedNoteIterator("D");
                    break;
                case 5:
                    this.noteIterator = new LoopedNoteIterator("A");
                    break;
            }

            for(int fret = 0 ; fret < container[string].length ; fret++){
                container[string][fret] = this.noteIterator.next();
            }
        }
    }

    private void populateImportantIntervalsMap(){
        importantIntervalsMap = new HashMap<>();
        importantIntervalsMap.put("C", new String[]{"C","D#","E","G","A#"});
        importantIntervalsMap.put("C#", new String[]{"C#","E","F","G#","H"});
        importantIntervalsMap.put("D", new String[]{"D","F","F#","A","C"});
        importantIntervalsMap.put("D#", new String[]{"D#","F#","G","A#","C#"});
        importantIntervalsMap.put("E", new String[]{"E","G","G#","H","D"});
        importantIntervalsMap.put("F", new String[]{"F","G#","A","C","D#"});
        importantIntervalsMap.put("F#", new String[]{"F#","A","A#","C#","E"});
        importantIntervalsMap.put("G", new String[]{"G","A#","H","D","F"});
        importantIntervalsMap.put("G#", new String[]{"G#","H","C","D#","F#"});
        importantIntervalsMap.put("A", new String[]{"A","C","C#","E","G"});
        importantIntervalsMap.put("A#", new String[]{"A#","C#","D","F","G#"});
        importantIntervalsMap.put("H", new String[]{"H","D","D#","F#","A"});


    }


    public String[] getFretNumbers(){
        return container[0];
    }

    public  String[] getNotesFromString(int stringNumber){
        return container[stringNumber];
    }

    //Returns array of 4 elemets : tonica , Min3, Maj3 , Perf5
    public  String[] getImportantIntervalsOf(String note){
        //TODO: replace fixed map of intervals with some generator.
        //SOlution below is too slow and does not keep up with speed of fired events
//        this.noteIterator = new LoopedNoteIterator(note);
//        for (int i = 0; i < 8 ; i++) {
//            if(i == 0 ){
//                result[0] = this.noteIterator.next();
//            }else if (i == 3){
//                result[1] = this.noteIterator.next();
//            }else if(i == 4 ){
//
//            }else if ( i == 7){
//                result[3] = this.noteIterator.next();
//            }
//
//        }
        return importantIntervalsMap.get(note);
    }

}
