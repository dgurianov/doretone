package com.doretone.components.chordrandomizer;

import com.doretone.core.GuiVariables;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class ChordPanel extends JPanel {

    private final JLabel invisibleLabel;
    private final JLabel displayLabel;

    public ChordPanel() {
        invisibleLabel  = new JLabel(GuiVariables.GLB_EMPTY.getValue());
        displayLabel = new JLabel(GuiVariables.CHORD_RND_LABEL_NO_CHORD.getValue(), SwingConstants.CENTER);
        displayLabel.setFont(new Font("Serif", Font.BOLD, 60));


        //Setting form border
        Border innerBorder = BorderFactory.createTitledBorder(GuiVariables.CHORD_RND_BORDER_CHORD_PANEL.getValue());
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        setLayout(new BorderLayout());
        add(displayLabel,BorderLayout.CENTER);

        Dimension dim = getPreferredSize();
        dim.width = 250;
        setPreferredSize(dim);

    }

    public void setChord(String chord){
        displayLabel.setText(chord);
    }

    public void setChordAndColor(String[] chordColored){
        if(chordColored[0].equalsIgnoreCase("0")){
            //Minor, blue
            displayLabel.setForeground(Color.blue);
            setChord(chordColored[1]);

        }else if (chordColored[0].equalsIgnoreCase("1")){
            //Major, red
            displayLabel.setForeground(Color.red);
            setChord(chordColored[1]);
        }else{
            //Unknown, black
            displayLabel.setForeground(Color.black);
            setChord(chordColored[1]);
        }
    }
}
