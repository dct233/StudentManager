package com.nocl.studentmanager.view.main.ddl.listener;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class StudentClassComboBoxListener implements ItemListener {
    private final JButton addButton;
    public StudentClassComboBoxListener(JButton addButton) {
        this.addButton = addButton;
    }
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getItem() != null) {
            addButton.setEnabled(true);
        }
    }
}
