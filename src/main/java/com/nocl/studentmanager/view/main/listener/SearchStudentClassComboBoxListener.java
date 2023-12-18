package com.nocl.studentmanager.view.main.listener;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import static com.nocl.studentmanager.view.main.StudentMain.dao;

public class SearchStudentClassComboBoxListener implements ItemListener {
    private final JComboBox<String> comboBox;
    private final JComboBox<String> childComboBox;
    private boolean select = false;

    public SearchStudentClassComboBoxListener(JComboBox<String> comboBox, JComboBox<String> childComboBox) {
        this.comboBox = comboBox;
        this.childComboBox = childComboBox;
    }
    @Override
    public void itemStateChanged(ItemEvent e) {
        System.out.println("栈触发");
        JComboBox<String> temp = (JComboBox<String>) e.getSource();
        System.out.println();
        // 处理父容器为空时的数据
        if (comboBox.getSelectedItem() == null && e.getStateChange() == ItemEvent.SELECTED) {
            System.out.println("栈1触发");
            String spec = dao.getStudentClassOfSpecialized((String) e.getItem());
            String ace = dao.getSpecializedOfAcademy(spec);

            comboBox.setSelectedItem(ace);
            childComboBox.setSelectedItem(spec);
            temp.removeAllItems();
            temp.addItem(null);
            for (String item : dao.getStudentClass(spec)) {
                temp.addItem(item);
            }
            temp.setSelectedItem(e.getItem());

            return;
        }
        // 处理子容器为空时的逻辑
        if (childComboBox.getSelectedItem() == null) {
            System.out.println("栈2触发");
            ItemListener comboBoxItemListener = comboBox.getItemListeners()[0];
            comboBox.removeItemListener(comboBoxItemListener);

            String tempSelectItem = (String) temp.getSelectedItem();
            comboBox.setSelectedItem(dao.getStudentClassOfAcademy(tempSelectItem));

            comboBox.addItemListener(comboBoxItemListener);

            return;
        }
        // 处理两个容器皆为空时的数据
        if (comboBox.getSelectedItem() == null && childComboBox.getSelectedItem() == null) {
            System.out.println("栈3触发");
            // 临时关闭自身的item监听, 防止栈溢出
            temp.removeItemListener(this);

            String studentClassSelect = (String) temp.getSelectedItem();
            temp.removeAllItems();
            temp.addItem(null);
            for (String item : dao.getAllStudentClass()) {
                temp.addItem(item);
            }

            temp.setSelectedItem(studentClassSelect);
            temp.addItemListener(this);
        }
    }
}
