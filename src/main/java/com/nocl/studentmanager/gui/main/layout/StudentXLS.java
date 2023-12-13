package com.nocl.studentmanager.gui.main.layout;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class StudentXLS extends JPanel {
    private final GridBagConstraints gbc;
    private JTable studentTable;

    public StudentXLS() {
        this.setBackground(Color.BLACK);
        GridBagLayout layout = new GridBagLayout();
        layout.columnWidths = new int[1];
        layout.rowHeights = new int[1];
        layout.rowWeights = new double[] {1.0};
        layout.columnWeights = new double[] {1.0};
        this.setLayout(layout);

        // 外部GBC
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 2;
        initStudentTable();
    }
    private void initStudentTable() {
        studentTable = new JTable(30, 5);
        studentTable.setFont(new Font("微软雅黑", Font.BOLD, 14));

        GridBagConstraints layout = new GridBagConstraints();
        layout.insets = new Insets(1, 1, 0, 0);
        layout.fill = GridBagConstraints.BOTH;
        layout.gridx = 0;
        layout.gridy = 0;
        layout.gridwidth = 1;
        layout.gridheight = 1;

        this.add(studentTable, layout);
    }

    public GridBagConstraints getGbc() {
        return gbc;
    }
    // 自定义渲染器类
}
