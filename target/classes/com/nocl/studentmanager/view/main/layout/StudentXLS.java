package com.nocl.studentmanager.view.main.layout;

import com.nocl.studentmanager.view.main.utils.StudentXLSUtils;
import com.nocl.studentmanager.view.main.utils.listener.TableListSelectionListener;
import com.nocl.studentmanager.view.main.utils.listener.TableModelListener;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

import static com.nocl.studentmanager.view.main.StudentMain.dao;

public class StudentXLS extends JPanel {
    private final GridBagConstraints gbc;
    private JTable studentTable;
    private DefaultTableModel model;
    public static TableModelListener tableModelListener;
    public static TableListSelectionListener tableListSelectionListener;

    public StudentXLS() {
        //this.setBackground(Color.BLACK);
        GridBagLayout layout = new GridBagLayout();
        layout.columnWidths = new int[1];
        layout.rowHeights = new int[2];
        layout.rowWeights = new double[] {0.8, 0.2};
        layout.columnWeights = new double[] {1.0};
        this.setLayout(layout);

        // 外部GBC
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        initStudentTable();
    }
    private void initStudentTable() {
        model = StudentXLSUtils.setStudentTable(dao.getStudentInfo(null), null);
        tableModelListener = new TableModelListener(model, null);
        model.addTableModelListener(tableModelListener);
        // 设置表格Model
        studentTable = new JTable(model);
        studentTable.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        studentTable.setRowHeight(25);
        tableListSelectionListener = new TableListSelectionListener(model);
        studentTable.getSelectionModel().addListSelectionListener(tableListSelectionListener);
        // 设置表头样式
        JTableHeader studentTableHeader = new JTableHeader(studentTable.getColumnModel());
        studentTableHeader.setFont(new Font("微软雅黑", Font.BOLD, 14));
        studentTable.setTableHeader(studentTableHeader);
        /*studentTable.setTableHeader(studentTableHeader);*/
        JScrollPane scrollPane = new JScrollPane(studentTable);
        //scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        GridBagConstraints layout = new GridBagConstraints();
        layout.insets = new Insets(1, 1, 0, 0);
        layout.fill = GridBagConstraints.BOTH;
        layout.gridx = 0;
        layout.gridy = 0;
        layout.gridwidth = 1;
        layout.gridheight = 1;

        this.add(scrollPane, layout);
    }

    public GridBagConstraints getGbc() {
        return gbc;
    }

    public DefaultTableModel getModel() {
        return model;
    }

    public JTable getStudentTable() {

        return studentTable;
    }

    public void setModel(DefaultTableModel model) {
        // studentTable = new JTable(model);
        studentTable.setModel(model);
    }
}
