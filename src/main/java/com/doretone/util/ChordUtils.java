package com.doretone.util;

public class ChordUtils {

    public static String removeMinorSymbol(String chord){
        return chord.replaceAll("m","");

    }
}
