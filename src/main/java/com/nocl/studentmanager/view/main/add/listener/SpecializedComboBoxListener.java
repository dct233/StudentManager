package com.nocl.studentmanager.view.main.add.listener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import static com.nocl.studentmanager.view.main.StudentMain.dao;

public class SpecializedComboBoxListener implements ItemListener {
    private final JComboBox<String> studentClassComboBox;
    private final boolean defaultEnable;
    public SpecializedComboBoxListener(JComboBox<String> studentClassComboBox, boolean defaultEnable) {
        this.studentClassComboBox = studentClassComboBox;
        this.defaultEnable = defaultEnable;
    }
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (studentClassComboBox != null) {
            if (e.getItem() != null) {
                if (studentClassComboBox.getItemCount() > 1 && !defaultEnable) {
                    studentClassComboBox.removeAllItems();
                    studentClassComboBox.setEnabled(false);
                    return;
                }
                studentClassComboBox.removeAllItems();
                studentClassComboBox.addItem(null);
                for (String item : dao.getStudentClass((String) e.getItem())) {
                    studentClassComboBox.addItem(item);
                }

                studentClassComboBox.setFont(new Font("微软雅黑", Font.PLAIN, 15));
                studentClassComboBox.setEnabled(true);
            }
        }
    }
}
