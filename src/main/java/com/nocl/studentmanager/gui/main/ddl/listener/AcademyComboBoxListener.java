package com.nocl.studentmanager.gui.main.ddl.listener;

import com.nocl.studentmanager.gui.main.ddl.AddStudentInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import static com.nocl.studentmanager.gui.main.StudentMain.dao;

public class AcademyComboBoxListener implements ItemListener {
    private final JComboBox<String> specializedComboBox;
    public AcademyComboBoxListener(JComboBox<String> specializedComboBox) {
        this.specializedComboBox = specializedComboBox;
    }
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getItem() != null) {
            for (String item : dao.getSpecialized((String) e.getItem())) {
                specializedComboBox.addItem(item);
            }

            specializedComboBox.setFont(new Font("微软雅黑", Font.PLAIN, 15));
            specializedComboBox.setEnabled(true);
        }
    }
}
