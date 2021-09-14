package com.doretone.components.notesneck;

import com.doretone.components.events.ChordChangeEvent;
import com.doretone.components.intervallegendtable.constants.ColumnOrder;
import com.doretone.components.intervallegendtable.constants.IntervalLegendColor;
import com.doretone.components.intervallegendtable.constants.IntervalLegendColumnWidth;
import com.doretone.components.intervallegendtable.constants.IntervalLegendKeys;
import com.doretone.components.listeners.ChordChangeListener;
import com.doretone.components.renderers.NoteNeckTableRenderer;
import com.doretone.core.exceptions.InvalidNoteException;
import com.doretone.util.ChordUtils;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.Arrays;

public class NoteNeckTable extends JTable implements  ChordChangeListener {
    private final NoteNeckContainer container = new NoteNeckContainer();
    private final NoteNeckTableRenderer renderer = new NoteNeckTableRenderer();
    public NoteNeckTable(TableModel dm) {
        super(dm);
        //Set column sizes
        //Total available width
        setAutoResizeMode(JTable.AUTO_RESIZE_OFF);//Do not resize columns automagically
        getColumnModel().getColumn(0).setPreferredWidth(75);
        setRowHeight(18);
        getColumnModel().getColumn(1).setPreferredWidth(75);
        getColumnModel().getColumn(2).setPreferredWidth(75);
        getColumnModel().getColumn(3).setPreferredWidth(75);
        getColumnModel().getColumn(4).setPreferredWidth(75);
        getColumnModel().getColumn(5).setPreferredWidth(75);
        getColumnModel().getColumn(6).setPreferredWidth(75);
        setDefaultRenderer(String.class, renderer);

    }

    @Override
    public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
        Component comp = super.prepareRenderer(renderer, row, column);
        ((DefaultTableCellRenderer) renderer).setHorizontalAlignment(SwingConstants.CENTER);
//        Object value = getModel().getValueAt(row, column);
//        if(row == 0) {
//            comp.setBackground(IntervalLegendColor.TONICA.getValue());
//        }else if (row == 4) {
//            comp.setBackground(IntervalLegendColor.MINOR3.getValue());
//        }else if(row == 5){
//            comp.setBackground(IntervalLegendColor.MAJOR3.getValue());
//        }else if(row == 8) {
//            comp.setBackground(IntervalLegendColor.PERFECT5.getValue());
//        }else{
//            comp.setBackground(IntervalLegendColor.DEFAULT.getValue());
//        }

        return comp;
    }




    @Override
    public void chordChangeOccurred(ChordChangeEvent event) {
        System.out.println(event.getChord());
        System.out.println(Arrays.toString(container.getImportantIntervalsOf(ChordUtils.removeMinorSymbol(event.getChord()))));
        renderer.setCellsToColor(container.getImportantIntervalsOf(ChordUtils.removeMinorSymbol(event.getChord())));
        this.repaint();
    }
}
