package com.nocl.studentmanager.view.main.layout;

import javax.swing.*;
import java.awt.*;

public class UtilsMenu extends JPanel {
    private final GridBagConstraints gbc;

    public UtilsMenu() {
        this.setBackground(Color.GREEN);
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
