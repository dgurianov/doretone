package com.doretone.components.renderers;

import com.doretone.components.intervallegendtable.constants.IntervalLegendColor;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class NoteNeckTableRenderer extends DefaultTableCellRenderer {
    private String[]  cellsToColor = {"X","X","X","X","X"};
    private final Color original = IntervalLegendColor.DEFAULT.getValue();
    private final Color openStrings = IntervalLegendColor.GRAY.getValue();


    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component superComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        String strValue = value.toString();
        if( hasSlash(strValue)){
            String[] pairOfNotes = strValue.split("/");

            if (pairOfNotes[0].matches(cellsToColor[0]) || pairOfNotes[1].matches(cellsToColor[0]) ){
                superComponent.setBackground(IntervalLegendColor.TONICA.getValue());

            } else if (pairOfNotes[0].matches(cellsToColor[1]) || pairOfNotes[1].matches(cellsToColor[1])) {
                superComponent.setBackground(IntervalLegendColor.MINOR3.getValue());
            }else if (pairOfNotes[0].matches(cellsToColor[2]) || pairOfNotes[1].matches(cellsToColor[2])) {
                superComponent.setBackground(IntervalLegendColor.MAJOR3.getValue());
            }else if (pairOfNotes[0].matches(cellsToColor[3]) || pairOfNotes[1].matches(cellsToColor[3])) {
                superComponent.setBackground(IntervalLegendColor.PERFECT5.getValue());
            }else if (pairOfNotes[0].matches(cellsToColor[4]) || pairOfNotes[1].matches(cellsToColor[4])) {
                superComponent.setBackground(IntervalLegendColor.MINOR7.getValue());
            }else {
                if(column == 0){
                    superComponent.setBackground(openStrings);
                }else {
                    superComponent.setBackground(original);
                }
            }
        }else{
            if (strValue.matches(cellsToColor[0])){
                superComponent.setBackground(IntervalLegendColor.TONICA.getValue());

            } else if (strValue.matches(cellsToColor[1])) {
                superComponent.setBackground(IntervalLegendColor.MINOR3.getValue());
            }else if (strValue.matches(cellsToColor[2])) {
                superComponent.setBackground(IntervalLegendColor.MAJOR3.getValue());
            }else if (strValue.matches(cellsToColor[3])) {
                superComponent.setBackground(IntervalLegendColor.PERFECT5.getValue());
            }else if (strValue.matches(cellsToColor[4])) {
                superComponent.setBackground(IntervalLegendColor.MINOR7.getValue());
            }else {
                if(column == 0){
                    superComponent.setBackground(openStrings);
                }else {
                    superComponent.setBackground(original);
                }
            }
        }
        return superComponent;
    }



    private boolean isNoteInCurrentCell(String note , String cellValue){
        return cellValue.matches(note);
    }

    private boolean hasSlash(String str){
        return str.matches("."+String.valueOf("*")+"/"+"."+String.valueOf("*"));
    }

    public void setCellsToColor(String[] cellsToColor) {
        this.cellsToColor = cellsToColor;
    }
}
