package com.nocl.studentmanager.view.main.utils.listener;

import com.nocl.studentmanager.Main;
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
            Main.LOGGER.debug("入备份");
            if (StudentXLS.studentTableModelListener != null) {
                Vector<Vector<Object>> temp = new Vector<>();

                for (Vector i : model.getDataVector()) {
                    Vector<Object> forTemp = new Vector<Object>(i);
                    temp.add(forTemp);
                }

                model.removeTableModelListener(StudentXLS.studentTableModelListener);
                StudentXLS.studentTableModelListener.setOldModel(temp);
                model.addTableModelListener(StudentXLS.studentTableModelListener);
            }
        }
        source.addListSelectionListener(this);
    }

    public void setModel(DefaultTableModel model) {
        this.model = model;
    }
}
