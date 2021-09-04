package com.doretone.core;

import com.doretone.components.chordrandomizer.FormPanel;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    //Chord Randomizer
    private final FormPanel chordRndFormPanel;

    public MainFrame()  {
        super(String.format("%s v. %s",GuiVariables.MAIN_FRAME_HEADER_MESSAGE.getValue(),GuiVariables.GLB_APP_VERSION.getValue()));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(300,500);  //Gray window
        setLayout(new BorderLayout());
        setResizable(false);

        chordRndFormPanel = new FormPanel();
        add(chordRndFormPanel,BorderLayout.CENTER);

    }
}
