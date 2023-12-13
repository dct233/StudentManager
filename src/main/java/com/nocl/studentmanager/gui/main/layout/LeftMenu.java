package com.nocl.studentmanager.gui.main.layout;

import javax.swing.*;
import java.awt.*;

public class LeftMenu extends JPanel {
    private final GridBagConstraints gbc;

    public LeftMenu() {
        this.setLayout(null);
        this.setBackground(Color.CYAN);
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 0, 5, 0);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 2;
    }

    public GridBagConstraints getGbc() {
        return gbc;
    }
}
