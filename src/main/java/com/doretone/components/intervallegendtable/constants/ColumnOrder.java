package com.doretone.components.intervallegendtable.constants;

import java.util.Arrays;
import java.util.List;

public class ColumnOrder {
    //Order of the columns in table
    private static final String[] order = new String[]{
            IntervalLegendKeys.SEMITONES,
            IntervalLegendKeys.ROMAN,
            IntervalLegendKeys.ARABIC,
            IntervalLegendKeys.ENG,
            IntervalLegendKeys.RUS,
            IntervalLegendKeys.SYMBOLS

    };
    private static final List<String> columns = Arrays.asList(order);

    public static int getColumnPositionByLegendKey(String key){
        return columns.indexOf(key);
    }

    public static String getColumnNameByPosition(int position){
        return columns.get(position);
    }

    public static int getColumnsAmount(){
        return columns.size();
    }
}
