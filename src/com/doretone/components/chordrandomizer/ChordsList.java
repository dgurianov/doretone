package com.doretone.components.chordrandomizer;

import java.util.HashMap;
import java.util.Random;

public class ChordsList {
    private HashMap<Integer,String> chordsList = new HashMap<>();
    private Random rand = new Random();

    public ChordsList() {
        //Warm up
        populateChordList(chordsList);
    }

    public String getRandom(){
            return chordsList.get(rand.nextInt(24));
    }

    public String[] getRandomMajMin(){
        String chord = chordsList.get(rand.nextInt(24));
        if(chord.length() > 1 && chord.charAt(1) == 'm'){
            return new String[] {"0",chord};
        }else {
            return new String[] {"1",chord};
        }
    }

    private void populateChordList(HashMap<Integer,String> list){
        list.put(0,"A");
        list.put(1,"A#");
        list.put(2,"C");
        list.put(3,"C#");
        list.put(4,"D");
        list.put(5,"D#");
        list.put(6,"E");
        list.put(7,"F");
        list.put(8,"F#");
        list.put(9,"H");
        list.put(10,"G");
        list.put(11,"G#");
        list.put(12,"Am");
        list.put(13,"Am#");
        list.put(14,"Cm");
        list.put(15,"Cm#");
        list.put(16,"Dm");
        list.put(17,"Dm#");
        list.put(18,"Em");
        list.put(19,"Fm");
        list.put(20,"Fm#");
        list.put(21,"Hm");
        list.put(22,"Gm");
        list.put(23,"Gm#");
    }

}
