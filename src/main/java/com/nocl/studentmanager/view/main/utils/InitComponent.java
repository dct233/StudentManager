package com.nocl.studentmanager.view.main.utils;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class InitComponent {
    public static JLabel initLabel(String label, int[] labelAddr, JPanel parentPanel) {
        JLabel jLabel = new JLabel(label);
        jLabel.setFont(new Font("微软雅黑", Font.BOLD, 13));

        GridBagConstraints labelGbc = new GridBagConstraints();
        labelGbc.fill = GridBagConstraints.BOTH;
        labelGbc.insets = new Insets(5, 0, 5, 5);
        labelGbc.anchor = GridBagConstraints.LINE_END;
        labelGbc.gridx = labelAddr[0];
        labelGbc.gridy = labelAddr[1];
        labelGbc.gridwidth = labelAddr[2];
        labelGbc.gridheight = labelAddr[3];

        JPanel labelPanel = new JPanel();
        labelPanel.add(jLabel);

        parentPanel.add(labelPanel, labelGbc);

        return jLabel;
    }

    public static JTextField initInput(String label, int[] labelAddr, int[] inputAddr, JPanel parentPanel) {
        JTextField textField = new JTextField();
        textField.setFont(new Font("微软雅黑", Font.BOLD, 13));

        GridBagConstraints textFieldGbc = new GridBagConstraints();
        textFieldGbc.fill = GridBagConstraints.BOTH;
        textFieldGbc.insets = new Insets(5, 0, 5, 5);
        textFieldGbc.gridx = inputAddr[0];
        textFieldGbc.gridy = inputAddr[1];
        textFieldGbc.gridwidth = inputAddr[2];
        textFieldGbc.gridheight = inputAddr[3];

        initLabel(label, labelAddr, parentPanel);
        parentPanel.add(textField, textFieldGbc);

        return textField;
    }

    public static JComboBox<String> initComboBox(String label, List<String> data, int[] labelAddr, int[] comboBoxAddr, JPanel parentPanel) {
        JComboBox<String> comboBox;

        GridBagConstraints comboBoxGbc = new GridBagConstraints();
        comboBoxGbc.fill = GridBagConstraints.BOTH;
        comboBoxGbc.insets = new Insets(5, 0, 5, 5);
        comboBoxGbc.gridx = comboBoxAddr[0];
        comboBoxGbc.gridy = comboBoxAddr[1];
        comboBoxGbc.gridwidth = comboBoxAddr[2];
        comboBoxGbc.gridheight = comboBoxAddr[3];
        initLabel(label, labelAddr, parentPanel);
        try {
            // 初始化时添加空选项
            if (data.get(0) != null) {
                data.add(0, null);
            }
            comboBox = new JComboBox<>(data.toArray(String[]::new));
            comboBox.setFont(new Font("微软雅黑", Font.PLAIN, 15));
            // 固定大小, 防止选择时导致空间挤压
            comboBox.setPreferredSize(new Dimension(10, 30));

            parentPanel.add(comboBox, comboBoxGbc);
        } catch (NullPointerException e) {
            //LOGGER.error(e);
            //LOGGER.error(label + "为空, 请先添加一个" + label + "组");
            comboBox = new JComboBox<>(new String[] {});
            parentPanel.add(comboBox, comboBoxGbc);
        }
        return comboBox;
    }
}
