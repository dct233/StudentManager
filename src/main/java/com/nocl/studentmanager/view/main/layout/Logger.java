package com.nocl.studentmanager.view.main.layout;

import javax.swing.*;
import java.awt.*;

public class Logger extends JPanel {
    private final GridBagConstraints gbc;
    private JTextArea log;
    private JLabel loggerTitle;

    public Logger() {
        GridBagLayout layout = new GridBagLayout();
        layout.columnWidths = new int[1];
        layout.rowHeights = new int[2];
        layout.columnWeights = new double[] {1.0};
        layout.rowWeights = new double[] {0.1, 0.9};
        this.setLayout(layout);

        this.setBackground(new Color(46, 46, 46));

        gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 0, 5, 0);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;

        initLogger();
        initLoggerTitle();
    }

    private void initLogger() {
        log = new JTextArea();

        log.setEditable(false);
        log.setLineWrap(true);
        log.setWrapStyleWord(true);
        log.setSize(200, 300);
        log.setForeground(Color.GRAY);
        //log.setBackground(Color.GRAY);
        log.setFont(new Font("微软雅黑", Font.BOLD, 15));


        //JScrollPane scrollPane = new JScrollPane(log);

        GridBagConstraints logGbc = new GridBagConstraints();
        logGbc.insets = new Insets(0, 5, 5, 5);
        logGbc.fill = GridBagConstraints.BOTH;
        logGbc.gridx = 0;
        logGbc.gridy = 1;
        logGbc.gridheight = 1;
        logGbc.gridwidth = 1;

        this.add(log, logGbc);
    }

    private void initLoggerTitle() {
        loggerTitle = new JLabel("日志");
        loggerTitle.setFont(new Font("微软雅黑", Font.BOLD, 17));
        loggerTitle.setForeground(Color.WHITE);

        GridBagConstraints loggerTitleGbc = new GridBagConstraints();
        loggerTitleGbc.insets = new Insets(0, 5, 0, 0);
        loggerTitleGbc.fill = GridBagConstraints.NONE;
        loggerTitleGbc.gridx = 0;
        loggerTitleGbc.gridy = 0;
        loggerTitleGbc.gridwidth = 1;
        loggerTitleGbc.gridheight = 1;

        this.add(loggerTitle, loggerTitleGbc);
    }

    public GridBagConstraints getGbc() {
        return gbc;
    }

    public JTextArea getLog() {
        return log;
    }
}
