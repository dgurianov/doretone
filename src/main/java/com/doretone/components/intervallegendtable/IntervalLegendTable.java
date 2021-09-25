package com.doretone.components.intervallegendtable;

import com.doretone.components.intervallegendtable.constants.ColumnOrder;
import com.doretone.components.intervallegendtable.constants.IntervalLegendColor;
import com.doretone.components.intervallegendtable.constants.IntervalLegendColumnWidth;
import com.doretone.components.intervallegendtable.constants.IntervalLegendKeys;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import java.awt.*;

public class IntervalLegendTable extends JTable {
    public IntervalLegendTable(TableModel dm) {
        super(dm);
        //Set column sizes
        //Total available width
        setAutoResizeMode(JTable.AUTO_RESIZE_OFF);//Do not resize columns automagically, cause it does not honor fields for specific language
        getColumnModel().getColumn(ColumnOrder.getColumnPositionByLegendKey(IntervalLegendKeys.SEMITONES)).setPreferredWidth(IntervalLegendColumnWidth.SEMITONES.getValue());
        getColumnModel().getColumn(ColumnOrder.getColumnPositionByLegendKey(IntervalLegendKeys.RUS)).setPreferredWidth(IntervalLegendColumnWidth.RUS.getValue());
        getColumnModel().getColumn(ColumnOrder.getColumnPositionByLegendKey(IntervalLegendKeys.ENG)).setPreferredWidth(IntervalLegendColumnWidth.ENG.getValue());
        getColumnModel().getColumn(ColumnOrder.getColumnPositionByLegendKey(IntervalLegendKeys.ROMAN)).setPreferredWidth(IntervalLegendColumnWidth.ROMAN.getValue());
        getColumnModel().getColumn(ColumnOrder.getColumnPositionByLegendKey(IntervalLegendKeys.SYMBOLS)).setPreferredWidth(IntervalLegendColumnWidth.SYMBOLS.getValue());
        getColumnModel().getColumn(ColumnOrder.getColumnPositionByLegendKey(IntervalLegendKeys.ARABIC)).setPreferredWidth(IntervalLegendColumnWidth.ARABIC.getValue());
    }

    @Override
    public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
        Component comp = super.prepareRenderer(renderer, row, column);
        ((DefaultTableCellRenderer) renderer).setHorizontalAlignment(SwingConstants.CENTER);
        Object value = getModel().getValueAt(row, column);
        if(row == 0) {
            comp.setBackground(IntervalLegendColor.TONICA.getValue());
        }else if (row == 3) {
            comp.setBackground(IntervalLegendColor.MINOR3.getValue());
        }else if(row == 4){
            comp.setBackground(IntervalLegendColor.MAJOR3.getValue());
        }else if(row == 7) {
            comp.setBackground(IntervalLegendColor.PERFECT5.getValue());
        }else if(row == 10) {
            comp.setBackground(IntervalLegendColor.MINOR7.getValue());
        }else{
            comp.setBackground(IntervalLegendColor.DEFAULT.getValue());
        }

        return comp;
    }



}
