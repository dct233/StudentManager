package com.nocl.studentmanager.gui.main.ddl.listener;

import com.nocl.studentmanager.Main;
import com.nocl.studentmanager.gui.main.ddl.AddStudentInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import static com.nocl.studentmanager.gui.main.StudentMain.dao;

public class SpecializedComboBoxListener implements ItemListener {
    private final JComboBox<String> studentClassComboBox;
    public SpecializedComboBoxListener(JComboBox<String> studentClassComboBox) {
        this.studentClassComboBox = studentClassComboBox;
    }
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getItem() != null) {
            Main.LOGGER.debug("触发事件了");
            for (String item : dao.getStudentClass((String) e.getItem())) {
                studentClassComboBox.addItem(item);
            }

            studentClassComboBox.setFont(new Font("微软雅黑", Font.PLAIN, 15));
            studentClassComboBox.setEnabled(true);
        }
    }
}
