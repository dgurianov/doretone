package com.doretone.components.notesneck;

import com.doretone.components.chordrandomizer.ChordFormPanel;
import com.doretone.components.listeners.ChordChangeListener;
import com.doretone.core.GuiVariables;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class NotesNeckPanel extends JPanel {

    private final NoteNeckContainer container;
    private JTable table;

    public NotesNeckPanel() {
        container = new NoteNeckContainer();
        DefaultTableModel dtm = new DefaultTableModel(container.getFretNumbers(),0) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return String.class;
            }
        };
        table = new NoteNeckTable(dtm);
        setLayout(new BorderLayout());

        Dimension dim = getPreferredSize();
        dim.width = 250;
        setPreferredSize(dim);
        setMaximumSize(dim);
        setMinimumSize(dim);

        //Setting form border
        Border innerBorder = BorderFactory.createTitledBorder(GuiVariables.NOTES_NECK_HEADER.getValue());
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        //Populate row with notes
        dtm.addRow(container.getNotesFromString(1));
        dtm.addRow(container.getNotesFromString(2));
        dtm.addRow(container.getNotesFromString(3));
        dtm.addRow(container.getNotesFromString(4));
        dtm.addRow(container.getNotesFromString(5));
        dtm.addRow(container.getNotesFromString(6));
        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    public void addTableAsListener(ChordFormPanel chordPanel){
        chordPanel.addChordChangedListener((ChordChangeListener) table);

    }
}
