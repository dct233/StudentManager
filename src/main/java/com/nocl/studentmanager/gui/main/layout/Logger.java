package com.nocl.studentmanager.gui.main.layout;

import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.appender.ScriptAppenderSelector;

import javax.swing.*;
import java.awt.*;

public class Logger extends JPanel {
    private final GridBagConstraints gbc;


    public Logger() {
        this.setBackground(new Color(46, 46, 46));
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 0, 5, 0);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
    }

    public GridBagConstraints getGbc() {
        return gbc;
    }
}
