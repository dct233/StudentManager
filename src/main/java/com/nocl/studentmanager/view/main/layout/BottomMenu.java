package com.nocl.studentmanager.view.main.layout;

import javax.swing.*;
import java.awt.*;

public class BottomMenu extends JPanel {
    private final GridBagConstraints gbc;

    public BottomMenu() {
        // this.setBackground(Color.GREEN);
        GridBagLayout layout = new GridBagLayout();
        layout.columnWidths = new int[3];  // 列
        layout.rowHeights = new int[3];  // 行
        layout.columnWeights = new double[] {0.05, 0.7, 0.2}; // 列占比
        layout.rowWeights = new double[] {0.05, 0.475, 0.475}; // 行占比

        gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
    }

    public GridBagConstraints getGbc() {
        return gbc;
    }
}
