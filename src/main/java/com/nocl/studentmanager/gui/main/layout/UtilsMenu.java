package com.nocl.studentmanager.gui.main.layout;

import javax.swing.*;
import java.awt.*;

public class UtilsMenu extends JPanel {
    private final GridBagConstraints gbc;

    public UtilsMenu() {
        this.setBackground(Color.GREEN);
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 0, 5, 0);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
    }

    public GridBagConstraints getGbc() {
        return gbc;
    }
}
