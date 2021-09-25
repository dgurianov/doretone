package com.doretone.components.notesneck;

import com.doretone.components.events.ChordChangeEvent;
import com.doretone.components.listeners.ChordChangeListener;
import com.doretone.components.renderers.NoteNeckTableRenderer;
import com.doretone.util.ChordUtils;

import javax.swing.*;
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
        //Set height of the table rows
        setRowHeight(18);
        setDefaultRenderer(String.class, renderer);
    }

    @Override
    public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
        Component comp = super.prepareRenderer(renderer, row, column);
        ((DefaultTableCellRenderer) renderer).setHorizontalAlignment(SwingConstants.CENTER);
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
