package com.nocl.studentmanager.view.main.listener;

import java.util.List;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import static com.nocl.studentmanager.view.main.StudentMain.dao;

public class SearchAcademyComboBoxListener implements ItemListener {
    private final JComboBox<String> comboBox;
    private final JComboBox<String> childComboBox;
    public static boolean selected;

    public SearchAcademyComboBoxListener(JComboBox<String> comboBox, JComboBox<String> childComboBox) {
        this.comboBox = comboBox;
        this.childComboBox = childComboBox;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        System.out.println("A栈触发");
        JComboBox<?> temp = (JComboBox<?>) e.getSource();
        // 当自身选择null时
        if (temp.getSelectedItem() == null) {
            System.out.println("A栈触发1");
            selected = true;
            String comboBoxItem = (String) comboBox.getSelectedItem();
            comboBox.removeAllItems();
            for (String item : dao.getAllSpecialized()) {
                comboBox.addItem(item);
            }
            comboBox.setSelectedItem(comboBoxItem);
            // 子 ComboBox 根据父 ComboBox 的 Item 来查询所拥有的 Items
            String childComboBoxItem = (String) childComboBox.getSelectedItem();
            childComboBox.removeAllItems();
            childComboBox.addItem(null);
            for (String item : dao.getStudentClass(comboBoxItem)) {
                childComboBox.addItem(item);
            }
            childComboBox.setSelectedItem(childComboBoxItem);
            selected = false;
            return;
        }
        // 处理选择不为空标签时
        String comboBoxItem = (String) comboBox.getSelectedItem();
        comboBox.removeAllItems();
        comboBox.addItem(null);
        for (String item : dao.getSpecialized((String) e.getItem())) {
            comboBox.addItem(item);
        }
        comboBox.setSelectedItem(comboBoxItem);

        String childComboBoxItem = (String) childComboBox.getSelectedItem();
        childComboBox.removeAllItems();
        childComboBox.addItem(null);
        for (String item : dao.getAcademyOfStudentClass((String) e.getItem(), 1)) {
            childComboBox.addItem(item);
        }
        comboBox.setSelectedItem(comboBoxItem);
        selected = false;
    }
}
