package com.doretone.components.intervallegendtable;

import com.doretone.components.intervallegendtable.constants.ColumnOrder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import static com.doretone.components.intervallegendtable.constants.IntervalLegendKeys.*;

public class IntervalLegendTableContainer {
    private final HashMap<Integer, HashMap<String,String[]>> container;

    public IntervalLegendTableContainer() {
        this.container = new HashMap<>();
        populateContainer();
    }

    public ArrayList<String[]> getAllValuesNoColor(){
            ArrayList<String[]> result = new ArrayList<>();
            for (int key = 0; key < 12; key++){

                String[] newDataRow = new String[12];
                //Getting Hashmap with Interval info related to interval number
                HashMap<String, String[]> mapOfIntervalRelatedInfo = container.get(key);
                //0 element of the row is interval number which is from 0 to 12
                newDataRow[0] = String.valueOf(key);
                newDataRow[ColumnOrder.getColumnPositionByLegendKey(ROMAN)] = prettyPrintArray(mapOfIntervalRelatedInfo.get(ROMAN));
                newDataRow[ColumnOrder.getColumnPositionByLegendKey(ARABIC)] = prettyPrintArray(mapOfIntervalRelatedInfo.get(ARABIC));
                newDataRow[ColumnOrder.getColumnPositionByLegendKey(RUS)] = prettyPrintArray(mapOfIntervalRelatedInfo.get(RUS));
                newDataRow[ColumnOrder.getColumnPositionByLegendKey(ENG)] = prettyPrintArray(mapOfIntervalRelatedInfo.get(ENG));
                newDataRow[ColumnOrder.getColumnPositionByLegendKey(SYMBOLS)] = prettyPrintArray(mapOfIntervalRelatedInfo.get(SYMBOLS));

                result.add(newDataRow);
            }

            return result;
    }

    private String prettyPrintArray(String[] strArray){
        return Arrays.toString(strArray).replaceAll("[\\[\\]]","");
    }

    public String[] getTableHeader(){
        String[] result = new String[ColumnOrder.getColumnsAmount()];
        result[0] = SEMITONES;
        result[ColumnOrder.getColumnPositionByLegendKey(ROMAN)] = ROMAN;
        result[ColumnOrder.getColumnPositionByLegendKey(ARABIC)] = ARABIC;
        result[ColumnOrder.getColumnPositionByLegendKey(RUS)] = RUS;
        result[ColumnOrder.getColumnPositionByLegendKey(ENG)] = ENG;
        result[ColumnOrder.getColumnPositionByLegendKey(SYMBOLS)] = SYMBOLS;
        return result;
    }

    /*
    Hashmap mapping
    key equals of amount of semitones from tonic
    container.get(0)  - names of interval with 0 semitones
     */
    private void populateContainer(){
        for (int i = 0; i < 12; i++) {
            container.put(i,new HashMap<>());
        }
        loadData();
    }

    private void loadData(){
        HashMap<String,String[]> bucket;

        //Interval length 0
        bucket = container.get(0);
        bucket.put(ROMAN,new String[]{"I"});
        bucket.put(ARABIC,new String[]{"1"});
        bucket.put(RUS,new String[]{"Тоника"});
        bucket.put(ENG,new String[]{"Tonic"});
        bucket.put(SYMBOLS,new String[]{"T","R"});
        bucket.put(COLOR,new String[]{"red"});

        //Interval length 1
        bucket = container.get(1);
        bucket.put(ROMAN,new String[]{"II"});
        bucket.put(ARABIC,new String[]{"2-"});
        bucket.put(RUS,new String[]{"Малая секунда","м2"});
        bucket.put(ENG,new String[]{"Minor Second","Min 2"});
        bucket.put(SYMBOLS,new String[]{"b2"});
        bucket.put(COLOR,new String[]{"white"});

        //Interval length 2
        bucket = container.get(2);
        bucket.put(ROMAN,new String[]{"II"});
        bucket.put(ARABIC,new String[]{"2"});
        bucket.put(RUS,new String[]{"Большая секунда","б2"});
        bucket.put(ENG,new String[]{"Major Second","Maj 2"});
        bucket.put(SYMBOLS,new String[]{DELTA+"2"});
        bucket.put(COLOR,new String[]{"white"});

        //Interval length 3
        bucket = container.get(3);
        bucket.put(ROMAN,new String[]{"II","III"});
        bucket.put(ARABIC,new String[]{"2+","3"});
        bucket.put(RUS,new String[]{"Увеличенная секунда","ув2","Малая терция","м3"});
        bucket.put(ENG,new String[]{"Minor Third","Min 3","Dim 3"});
        bucket.put(SYMBOLS,new String[]{"b3"});
        bucket.put(COLOR,new String[]{"green"});

        //Interval length 4
        bucket = container.get(4);
        bucket.put(ROMAN,new String[]{"III","IV"});
        bucket.put(ARABIC,new String[]{"3","4-"});
        bucket.put(RUS,new String[]{"Большая терция","б3","Уменьшенная кварта","ум4"});
        bucket.put(ENG,new String[]{"Major Third","Maj 3"});
        bucket.put(SYMBOLS,new String[]{DELTA+"3"});
        bucket.put(COLOR,new String[]{"toxic green"});

        //Interval length 5
        bucket = container.get(5);
        bucket.put(ROMAN,new String[]{"III","IV"});
        bucket.put(ARABIC,new String[]{"3+","4"});
        bucket.put(RUS,new String[]{"Увеличенная терция","ув3","Чистая кварта","ч4"});
        bucket.put(ENG,new String[]{"Perfect Fourth","Perf 4"});
        bucket.put(SYMBOLS,new String[]{"p4"});
        bucket.put(COLOR,new String[]{"white"});

        //Interval length 6
        bucket = container.get(6);
        bucket.put(ROMAN,new String[]{"IV","V"});
        bucket.put(ARABIC,new String[]{"4+","5-"});
        bucket.put(RUS,new String[]{"Увеличенная кварта","ув4","Уменьшенная квинта","ум5","тритон"});
        bucket.put(ENG,new String[]{"Augmented 4th","Dim 4","Tritone"});
        bucket.put(SYMBOLS,new String[]{"Aug4"});
        bucket.put(COLOR,new String[]{"white"});

        //Interval length 7
        bucket = container.get(7);
        bucket.put(ROMAN,new String[]{"V"});
        bucket.put(ARABIC,new String[]{"5"});
        bucket.put(RUS,new String[]{"Чистая квинта"});
        bucket.put(ENG,new String[]{"Perfect Fifth"});
        bucket.put(SYMBOLS,new String[]{"p5"});
        bucket.put(COLOR,new String[]{"orange"});

        //Interval length 8
        bucket = container.get(8);
        bucket.put(ROMAN,new String[]{"V","VI"});
        bucket.put(ARABIC,new String[]{"5+","6-"});
        bucket.put(RUS,new String[]{"Увеличенная квинта","ув5","Уменьшенная секста","ум6"});
        bucket.put(ENG,new String[]{"Minor 6th","Min 6"});
        bucket.put(SYMBOLS,new String[]{"b6"});
        bucket.put(COLOR,new String[]{"white"});

        //Interval length 9
        bucket = container.get(9);
        bucket.put(ROMAN,new String[]{"VI","VII"});
        bucket.put(ARABIC,new String[]{"6","7-"});
        bucket.put(RUS,new String[]{"Большая секста","б6","Уменьшенная септима","ум7"});
        bucket.put(ENG,new String[]{"Major 6th","Maj 6"});
        bucket.put(SYMBOLS,new String[]{DELTA+"6"});
        bucket.put(COLOR,new String[]{"white"});

        //Interval length 10
        bucket = container.get(10);
        bucket.put(ROMAN,new String[]{"VII"});
        bucket.put(ARABIC,new String[]{"7"});
        bucket.put(RUS,new String[]{"Малая септима","м7"});
        bucket.put(ENG,new String[]{"Minor 7th","Min 7"});
        bucket.put(SYMBOLS,new String[]{"b7"});
        bucket.put(COLOR,new String[]{"white"});

        //Interval length 11
        bucket = container.get(11);
        bucket.put(ROMAN,new String[]{"VII"});
        bucket.put(ARABIC,new String[]{"7+"});
        bucket.put(RUS,new String[]{"Большая септима","б7"});
        bucket.put(ENG,new String[]{"Major 7th","Maj 7"});
        bucket.put(SYMBOLS,new String[]{DELTA+"7"});
        bucket.put(COLOR,new String[]{"white"});
    }
}
