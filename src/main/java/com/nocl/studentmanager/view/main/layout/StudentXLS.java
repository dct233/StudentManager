package com.nocl.studentmanager.view.main.layout;

import com.nocl.studentmanager.database.bean.Student;
import com.nocl.studentmanager.view.main.utils.StudentXLSUtils;
import com.nocl.studentmanager.view.main.utils.listener.TableListSelectionListener;
import com.nocl.studentmanager.view.main.utils.listener.StudentTableModelListener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

import static com.nocl.studentmanager.view.main.StudentMain.dao;

public class StudentXLS extends JPanel {
    private final GridBagConstraints gbc;
    private JTable studentTable;
    private DefaultTableModel model;
    private JLabel page;
    private JButton lastButton;
    private JButton nextButton;
    public static int maxPage = 0;
    public static int minPage = 1;
    public static Student student = null;
    public static StudentTableModelListener studentTableModelListener;
    public static TableListSelectionListener tableListSelectionListener;

    public StudentXLS() {
        //this.setBackground(Color.BLACK);
        GridBagLayout layout = new GridBagLayout();
        layout.columnWidths = new int[3];
        layout.rowHeights = new int[2];
        layout.rowWeights = new double[] {0.8, 0.2};
        layout.columnWeights = new double[] {0.4, 0.2, 0.4};
        this.setLayout(layout);

        // 外部GBC
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        initTablePage();
        initStudentTable();
    }
    private void initStudentTable() {
        List<Student> studentList = dao.getStudentInfo(null);
        maxPage = studentList.size() / 50;
        if (maxPage == 0) {
            lastButton.setEnabled(false);
            nextButton.setEnabled(false);
            model = StudentXLSUtils.setStudentTable(studentList);
        } else {
            lastButton.setEnabled(false);
            nextButton.setEnabled(true);

            page.setText("1 / " + (maxPage + 1));
            model = StudentXLSUtils.setStudentTable(studentList.subList(0, 50));
        }
        studentTableModelListener = new StudentTableModelListener(model);
        model.addTableModelListener(studentTableModelListener);
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
        layout.gridwidth = 3;
        layout.gridheight = 1;

        this.add(scrollPane, layout);
    }

    private void initTablePage() {
        lastButton = new JButton("上一页");
        page = new JLabel("1 / 1");
        nextButton = new JButton("下一页");

        lastButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                if (minPage == 1 && maxPage == 0) {
                    page.setText("1 / 1");
                    nextButton.setEnabled(false);
                    lastButton.setEnabled(false);
                }
                if (minPage != maxPage) {
                    nextButton.setEnabled(true);
                }
                if (lastButton.isEnabled()) {

                    model.removeTableModelListener(studentTableModelListener);
                    minPage--;
                    page.setText(minPage + " / " + (maxPage + 1));
                    model.setDataVector(StudentXLSUtils.tableDataToObjectArray(dao.getStudentIndex(student, (minPage - 1) * 50, 50)), StudentXLSUtils.headerTitle);
                    model.addTableModelListener(studentTableModelListener);
                    if (minPage <= 1) {
                        lastButton.setEnabled(false);
                    }
                }
            }
        });
        nextButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (minPage == 1 && maxPage == 0) {
                    page.setText("1 / 1");
                    nextButton.setEnabled(false);
                    lastButton.setEnabled(false);
                }
                if (minPage > 1) {
                    lastButton.setEnabled(true);
                }
                if (nextButton.isEnabled()) {
                    model.removeTableModelListener(studentTableModelListener);
                    minPage++;
                    page.setText(minPage + " / " + (maxPage + 1));
                    model.setDataVector(StudentXLSUtils.tableDataToObjectArray(dao.getStudentIndex(student, (minPage - 1) * 50, 50)), StudentXLSUtils.headerTitle);
                    model.addTableModelListener(studentTableModelListener);
                    if (minPage == maxPage + 1) {
                        nextButton.setEnabled(false);
                    }
                    if (minPage > 1) {
                        lastButton.setEnabled(true);
                    }
                }
            }
        });

        GridBagConstraints lastLayout = new GridBagConstraints();
        lastLayout.insets = new Insets(1, 1, 0, 0);
        lastLayout.fill = GridBagConstraints.BOTH;
        lastLayout.gridx = 0;
        lastLayout.gridy = 1;
        lastLayout.gridwidth = 1;
        lastLayout.gridheight = 1;

        GridBagConstraints pageLayout = new GridBagConstraints();
        pageLayout.insets = new Insets(1, 1, 0, 0);
        pageLayout.gridx = 1;
        pageLayout.gridy = 1;
        pageLayout.gridwidth = 1;
        pageLayout.gridheight = 1;

        GridBagConstraints nextLayout = new GridBagConstraints();
        nextLayout.insets = new Insets(1, 1, 0, 0);
        nextLayout.fill = GridBagConstraints.BOTH;
        nextLayout.gridx = 2;
        nextLayout.gridy = 1;
        nextLayout.gridwidth = 1;
        nextLayout.gridheight = 1;

        this.add(lastButton, lastLayout);
        this.add(page, pageLayout);
        this.add(nextButton, nextLayout);
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

    public JLabel getPage() {
        return page;
    }
    public JButton getLastButton() {
        return lastButton;
    }

    public JButton getNextButton() {
        return nextButton;
    }
}
