package com.doretone.components.intervallegendtable;

import com.doretone.core.GuiVariables;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class IntervalLegendTablePanel extends JPanel {

    private final IntervalLegendTableContainer container;
    private IntervalLegendTable table;

    public IntervalLegendTablePanel() {
        container = new IntervalLegendTableContainer();
        DefaultTableModel dtm = new DefaultTableModel(container.getTableHeader(),0);
        table = new IntervalLegendTable(dtm);
        setLayout(new BorderLayout());
        //Setting form border
        Border innerBorder = BorderFactory.createTitledBorder(GuiVariables.INTVL_LEGEND_PANEL_HEADER.getValue() );
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
        for (String[] s: container.getAllValuesNoColor() ) {
            dtm.addRow(s);

        }
        add(new JScrollPane(table), BorderLayout.CENTER);
    }
}
