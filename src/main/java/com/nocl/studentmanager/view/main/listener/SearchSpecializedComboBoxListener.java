package com.nocl.studentmanager.view.main.listener;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import static com.nocl.studentmanager.view.main.StudentMain.dao;

public class SearchSpecializedComboBoxListener implements ItemListener {
    private final JComboBox<String> comboBox;
    private final JComboBox<String> childComboBox;

    public SearchSpecializedComboBoxListener(JComboBox<String> comboBox, JComboBox<String> childComboBox) {
        this.comboBox = comboBox;
        this.childComboBox = childComboBox;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        System.out.println("B栈触发");
        JComboBox<String> temp = (JComboBox<String>) e.getSource();
        System.out.println();
        // 处理Aca选择空, 且因为自身导致Aca变为空时导致的栈溢出问题
        if (comboBox.getSelectedItem() == null && e.getStateChange() == ItemEvent.SELECTED && !SearchAcademyComboBoxListener.selected) {
            comboBox.setSelectedItem(dao.getSpecializedOfAcademy((String) e.getItem()));

            String tempSelectedItem = (String) e.getItem();
            temp.removeAllItems();
            temp.addItem(null);
            for (String item : dao.getSpecialized(dao.getSpecializedOfAcademy((String) e.getItem()))) {
                temp.addItem(item);
            }
            temp.setSelectedItem(tempSelectedItem);

            childComboBox.removeAllItems();
            childComboBox.addItem(null);
            for (String item : dao.getStudentClass((String) e.getItem())) {
                childComboBox.addItem(item);
            }

            return;
        }
        childComboBox.removeAllItems();
        childComboBox.addItem(null);
        for (String item : dao.getStudentClass((String) e.getItem())) {
            childComboBox.addItem(item);
        }
    }
}
