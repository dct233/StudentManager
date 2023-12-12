package com.nocl.studentmanager.gui.main.layout;

import javax.swing.*;
import java.awt.*;

public class StudentXLS extends JPanel {
    private final GridBagConstraints gbc;

    public StudentXLS() {
        this.setBackground(Color.magenta);
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 2;
    }

    public GridBagConstraints getGbc() {
        return gbc;
    }
}
