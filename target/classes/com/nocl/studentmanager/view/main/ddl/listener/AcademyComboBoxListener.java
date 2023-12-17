package com.nocl.studentmanager.view.main.ddl.listener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import static com.nocl.studentmanager.view.main.StudentMain.dao;

public class AcademyComboBoxListener implements ItemListener {
    private final JComboBox<String> specializedComboBox;
    public AcademyComboBoxListener(JComboBox<String> specializedComboBox) {
        this.specializedComboBox = specializedComboBox;
    }
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getItem() != null) {
            if (specializedComboBox.getItemCount() > 1) {
                specializedComboBox.removeAllItems();
                specializedComboBox.setEnabled(false);
                return;
            }
            for (String item : dao.getSpecialized((String) e.getItem())) {
                specializedComboBox.addItem(item);
            }

            specializedComboBox.setFont(new Font("微软雅黑", Font.PLAIN, 15));
            specializedComboBox.setEnabled(true);
        }
    }
}
