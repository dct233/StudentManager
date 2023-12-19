package com.nocl.studentmanager.view.main.utils.listener;

import com.nocl.studentmanager.view.main.layout.StudentXLS;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;

public class TableListSelectionListener implements ListSelectionListener {
    private DefaultTableModel model;
    public TableListSelectionListener(DefaultTableModel model) {
        this.model = model;
    }
    @Override
    public void valueChanged(ListSelectionEvent e) {
        ListSelectionModel source = (ListSelectionModel) e.getSource();
        source.removeListSelectionListener(this);
        // 每次选中表格时都备份一次旧表格, 用于查询失败时回退表格
        if (e.getValueIsAdjusting()) {
            if (StudentXLS.tableModelListener != null) {
                Vector<Vector> temp = new Vector<>();

                for (Vector i : model.getDataVector()) {
                    Vector<Object> forTemp = new Vector<>();
                    forTemp.addAll(i);
                    temp.add(forTemp);
                }

                model.removeTableModelListener(StudentXLS.tableModelListener);
                StudentXLS.tableModelListener.setOldModel(temp);
                model.addTableModelListener(StudentXLS.tableModelListener);
            }
        }
        source.addListSelectionListener(this);
    }

    public void setModel(DefaultTableModel model) {
        this.model = model;
    }
}
