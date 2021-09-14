package com.doretone.core;

import com.doretone.components.chordrandomizer.ChordFormPanel;
import com.doretone.components.intervallegendtable.IntervalLegendTablePanel;
import com.doretone.components.notesneck.NotesNeckPanel;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    //Chord Randomizer
    private final ChordFormPanel chordRndChordFormPanel;
    private final IntervalLegendTablePanel intervalLegendTablePanel;
    private final NotesNeckPanel notesNeckPanel;


    public MainFrame()  {
        super(String.format("%s v. %s",GuiVariables.MAIN_FRAME_HEADER_MESSAGE.getValue(),GuiVariables.GLB_APP_VERSION.getValue()));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(1800,500);  //Gray window
        setResizable(false);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.weighty = 1;

        gbc.weightx = 0.05;
        gbc.weighty = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        chordRndChordFormPanel = new ChordFormPanel();
        add(chordRndChordFormPanel,gbc);

//        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 3.5;
        gbc.weighty = 1;
        gbc.gridx = 1;
        gbc.gridy = 0;
        intervalLegendTablePanel = new IntervalLegendTablePanel();
        add(intervalLegendTablePanel, gbc);

        gbc.weightx = 3.5;
        gbc.weighty = 1;
        gbc.gridx = 1;
        gbc.gridy = 1;
        notesNeckPanel = new NotesNeckPanel();
        notesNeckPanel.addTableAsListener(chordRndChordFormPanel);
        add(notesNeckPanel, gbc);

    }
}
