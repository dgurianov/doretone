package com.doretone.components.chordrandomizer;

import com.doretone.components.events.ChordChangeEvent;
import com.doretone.components.listeners.ChordChangeListener;
import com.doretone.core.GuiVariables;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.EventListenerList;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChordFormPanel extends JPanel implements ActionListener  {

    private final JLabel timeIntervalLabel;
    private final JTextField timeIntervalField;
    private final JLabel invisibleLabel;
    private final JLabel displayLabel;
    private final JButton startButton;
    private final ChordPanel chordPanel;
    private Timer timer ;
    private final ChordsList chordsList ;
    private EventListenerList listenerList;

    public ChordFormPanel() {
        timeIntervalLabel = new JLabel(GuiVariables.CHORD_RND_LABEL_TIME_INTERVAL.getValue());
        invisibleLabel  = new JLabel(GuiVariables.GLB_EMPTY.getValue());
        displayLabel = new JLabel(GuiVariables.CHORD_RND_LABEL_NO_CHORD.getValue());
        startButton  = new JButton(GuiVariables.CHORD_RND_BUTTON_START.getValue());
        timeIntervalField = new JTextField("3",2);
        chordPanel = new ChordPanel();
        chordsList = new ChordsList();
        listenerList =  new EventListenerList();

        startButton.addActionListener(this);

        Dimension dim = getPreferredSize();
        dim.width = 250;
        setPreferredSize(dim);
        setMaximumSize(dim);
        setMinimumSize(dim);

        //Setting form border
        Border innerBorder = BorderFactory.createTitledBorder(GuiVariables.CHORD_RND_BORDER_FORM_PANEL.getValue());
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        //Clean default layout of the form
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.weighty = 1;

        //First row
         gbc.weightx = 1;
         gbc.weighty = 0.1;

         gbc.gridx = 0;
         gbc.gridy = 0;
         add(timeIntervalLabel,gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(timeIntervalField,gbc);

        //Second row
        gbc.weightx = 1;
        gbc.weighty = 0.1;

        gbc.gridx = 0;
        gbc.gridy = 1;

        add(startButton,gbc);
        //Third row Display
        gbc.weightx = 1;
        gbc.weighty = 2.0;

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 2;

        add(chordPanel,gbc);

        //Fourth row
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == startButton && startButton.getText().equalsIgnoreCase(GuiVariables.CHORD_RND_BUTTON_START.getValue())){
            this.timer = new Timer(Integer.parseInt(timeIntervalField.getText()) * 1000, this);
            timer.start();
            String[] newChord = chordsList.getRandomMajMin();
            ChordChangeEvent event = new ChordChangeEvent(this, newChord[1]);
            fireDetailEvent(event);
            chordPanel.setChordAndColor(newChord);
            startButton.setText(GuiVariables.CHORD_RND_BUTTON_STOP.getValue());

        }else if (e.getSource() == startButton && startButton.getText().equalsIgnoreCase(GuiVariables.CHORD_RND_BUTTON_STOP.getValue())){
            timer.stop();
            startButton.setText(GuiVariables.CHORD_RND_BUTTON_START.getValue());
        }else {
            //Go through listenerList , find proper ChordChangeListener listener and  trigger event occured with chord change event
            String[] newChord = chordsList.getRandomMajMin();
            ChordChangeEvent event = new ChordChangeEvent(this, newChord[1]);
            fireDetailEvent(event);
            chordPanel.setChordAndColor(newChord);

        }
    }


    public void fireDetailEvent(ChordChangeEvent event) {
        Object[] listeners = listenerList.getListenerList();

        for(int i=0; i < listeners.length; i += 2) {
            if(listeners[i] == ChordChangeListener.class) {
                ((ChordChangeListener)listeners[i+1]).chordChangeOccurred(event);
            }
        }
    }

    public void addChordChangedListener(ChordChangeListener listener) {
        listenerList.add(ChordChangeListener.class, listener);
    }

    public void removeDetailListener(ChordChangeListener listener) {
        listenerList.remove(ChordChangeListener.class, listener);
    }
}
