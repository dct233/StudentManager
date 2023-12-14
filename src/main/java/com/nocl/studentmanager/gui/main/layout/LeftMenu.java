package com.nocl.studentmanager.gui.main.layout;

import com.nocl.studentmanager.gui.main.StudentMain;
import com.nocl.studentmanager.gui.main.listener.LeftMenuListener;

import javax.swing.*;
import java.awt.*;

public class LeftMenu extends JPanel {
    private final GridBagConstraints gbc;
    private JLabel add;

    public LeftMenu() {
        GridBagLayout layout = new GridBagLayout();
        layout.columnWidths = new int[1];
        layout.rowHeights = new int[10];
        layout.columnWeights = new double[] {1.0};
        layout.rowWeights = new double[] {0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1};
        this.setLayout(layout);

        this.setBackground(Color.CYAN);

        gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 0, 5, 0);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 2;
        initLabel();
    }
    private void initLabel() {
        add = new JLabel("添加");
        add.setFont(new Font("微软雅黑", Font.BOLD, 16));
        //add.addMouseListener(new LeftMenuListener(StudentMain.studentXLS.getModel()).getAdd());

        GridBagConstraints addGbc = new GridBagConstraints();
        addGbc.gridx = 0;
        addGbc.gridy = 2;
        addGbc.gridwidth = 1;
        addGbc.gridheight = 1;

        this.add(add, addGbc);
    }


    public GridBagConstraints getGbc() {
        return gbc;
    }
}
