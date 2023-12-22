package com.nocl.studentmanager.view.main.add;

import com.nocl.studentmanager.Main;
import com.nocl.studentmanager.view.main.add.listener.AcademyComboBoxListener;
import com.nocl.studentmanager.view.main.utils.InitComponent;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.nocl.studentmanager.view.main.StudentMain.dao;
import static com.nocl.studentmanager.view.main.StudentMain.sqlSession;

public class AddGroup extends JDialog {
    private final JPanel mainPanel;
    private JComboBox<String> selectGroupComboBox;
    private JComboBox<String> selectComboBox1;
    private JComboBox<String> selectComboBox2;
    private JLabel academyLabel;
    private GridBagConstraints academyLabelGbc;
    private JLabel specializedLabel;
    private GridBagConstraints specializedLabelGbc;
    private JLabel studentClassLabel;
    private GridBagConstraints studentClassGbc;
    private JButton addGroupButton;
    private JTextField addGroupField;
    private final JDialog thisDialog;
    public AddGroup(JFrame frame) {
        super(frame);
        GridBagLayout layout = new GridBagLayout();
        layout.columnWidths = new int[4];
        layout.rowHeights = new int[8];
        layout.columnWeights = new double[] {0.01, 0.15, 0.35, 0.25};
        layout.rowWeights = new double[] {0.01, 0.01, 0.01, 0.01, 0.01, 0.01, 0.01, 0.01};
        mainPanel = new JPanel(layout);
        this.setSize(280, 300);
        this.setTitle("添加群组");
        initAllLabel();
        initComboBox();
        this.setContentPane(mainPanel);
        thisDialog = this;
    }

    private void initComboBox() {
        selectGroupComboBox = InitComponent.initNoLabelComboBox(
                new ArrayList<>() {{ add("院校"); add("专业"); add("班级"); }},
                new int[] {1, 1, 3, 1},
                GridBagConstraints.HORIZONTAL,
                GridBagConstraints.CENTER,
                new Insets(5, 0, 5, 5),
                mainPanel
        );
        InitComponent.initLabel("创建群组", new int[]{0, 1, 1, 1}, new Insets(0, 5, 5, 10), mainPanel);
        selectGroupComboBox.addItemListener(e -> {
            String item = (String) selectGroupComboBox.getSelectedItem();
            removeComponent();
            if (item != null) {
                switch (item) {
                    case "院校" -> {
                        // 将输入框交予院校
                        addGroupField = new JTextField();

                        GridBagConstraints fieldGbc = new GridBagConstraints();
                        fieldGbc.fill = GridBagConstraints.HORIZONTAL;
                        fieldGbc.insets = new Insets(5, 0, 5, 5);
                        fieldGbc.gridx = 1;
                        fieldGbc.gridy = 2;
                        fieldGbc.gridwidth = 3;
                        fieldGbc.gridheight = 1;

                        addGroupButton = new JButton("添加");

                        GridBagConstraints addButtonGbc = new GridBagConstraints();
                        addButtonGbc.gridx = 1;
                        addButtonGbc.gridy = 4;
                        addButtonGbc.gridwidth = 2;
                        addButtonGbc.gridheight = 1;

                        addGroupButton.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                super.mouseClicked(e);
                                if (addGroupField.getText().equals("")) {
                                    JOptionPane.showOptionDialog(thisDialog, "请填入院校名称", "错误", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, new Object[]{"确定"}, null);
                                    return;
                                }
                                if (addGroupButton.isEnabled()) {
                                    dao.insertAcademy(dao.getMaxAcademyId(), addGroupField.getText());
                                    sqlSession.commit();
                                    thisDialog.dispose();
                                    resetTree();
                                }
                            }
                        });

                        mainPanel.add(addGroupField, fieldGbc);
                        mainPanel.add(academyLabel, academyLabelGbc);
                        mainPanel.add(addGroupButton, addButtonGbc);

                    }
                    case "专业" -> {
                        // 将院校搜索赋予select1
                        selectComboBox1 = InitComponent.initNoLabelComboBox(
                                dao.getAcademy(),
                                new int[]{1, 2, 3, 1},
                                GridBagConstraints.HORIZONTAL,
                                GridBagConstraints.CENTER,
                                new Insets(5, 0, 5, 5),
                                mainPanel
                        );

                        addGroupField = new JTextField();
                        GridBagConstraints fieldGbc = new GridBagConstraints();
                        fieldGbc.fill = GridBagConstraints.HORIZONTAL;
                        fieldGbc.insets = new Insets(5, 0, 5, 5);
                        fieldGbc.gridx = 1;
                        fieldGbc.gridy = 3;
                        fieldGbc.gridwidth = 3;
                        fieldGbc.gridheight = 1;

                        addGroupButton = new JButton("添加");

                        GridBagConstraints addButtonGbc = new GridBagConstraints();
                        addButtonGbc.gridx = 1;
                        addButtonGbc.gridy = 5;
                        addButtonGbc.gridwidth = 2;
                        addButtonGbc.gridheight = 1;

                        addGroupButton.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                super.mouseClicked(e);
                                if (selectComboBox1.getSelectedItem() == null || addGroupField.getText().equals("")) {
                                    JOptionPane.showOptionDialog(thisDialog, "请填入名称并选择院校", "错误", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, new Object[]{"确定"}, null);
                                    return;
                                }
                                if (addGroupButton.isEnabled()) {
                                    dao.insertSpecialized(dao.getMaxAcademyId(), addGroupField.getText(), dao.getAcademyUid((String) selectComboBox1.getSelectedItem()));
                                    sqlSession.commit();
                                    thisDialog.dispose();
                                    resetTree();
                                }
                            }
                        });

                        mainPanel.add(addGroupField, fieldGbc);
                        mainPanel.add(academyLabel, academyLabelGbc);
                        mainPanel.add(specializedLabel, specializedLabelGbc);
                        mainPanel.add(addGroupButton, addButtonGbc);
                    }
                    case "班级" -> {
                        // 设置select1为院校, select2为院校下级的专业
                        selectComboBox1 = InitComponent.initNoLabelComboBox(
                                dao.getAcademy(),
                                new int[]{1, 2, 3, 1},
                                GridBagConstraints.HORIZONTAL,
                                GridBagConstraints.CENTER,
                                new Insets(5, 0, 5, 5),
                                mainPanel
                        );
                        selectComboBox2 = InitComponent.initNoLabelComboBox(
                                new ArrayList<>() {{
                                    add(null);
                                }},
                                new int[]{1, 3, 3, 1},
                                GridBagConstraints.HORIZONTAL,
                                GridBagConstraints.CENTER,
                                new Insets(5, 0, 5, 5),
                                mainPanel
                        );

                        selectComboBox1.addItemListener(new AcademyComboBoxListener(selectComboBox2, false));
                        selectComboBox2.setEnabled(false);

                        addGroupField = new JTextField();
                        GridBagConstraints fieldGbc = new GridBagConstraints();
                        fieldGbc.fill = GridBagConstraints.HORIZONTAL;
                        fieldGbc.insets = new Insets(5, 0, 5, 5);
                        fieldGbc.gridx = 1;
                        fieldGbc.gridy = 4;
                        fieldGbc.gridwidth = 3;
                        fieldGbc.gridheight = 1;

                        addGroupButton = new JButton("添加");

                        GridBagConstraints addButtonGbc = new GridBagConstraints();
                        addButtonGbc.gridx = 1;
                        addButtonGbc.gridy = 6;
                        addButtonGbc.gridwidth = 2;
                        addButtonGbc.gridheight = 1;

                        addGroupButton.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                super.mouseClicked(e);
                                if (selectComboBox1.getSelectedItem() == null || selectComboBox2.getSelectedItem() == null || addGroupField.getText().equals("")) {
                                    JOptionPane.showOptionDialog(thisDialog, "请填入名称并选择院校和专业", "错误", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, new Object[]{"确定"}, null);
                                    return;
                                }
                                if (addGroupButton.isEnabled()) {
                                    dao.insertStudentClass(dao.getMaxStudentClassId(), addGroupField.getText(), dao.getSpecializedUid((String) selectComboBox2.getSelectedItem()));
                                    sqlSession.commit();
                                    thisDialog.dispose();
                                    resetTree();
                                }
                            }
                        });

                        mainPanel.add(addGroupField, fieldGbc);
                        mainPanel.add(academyLabel, academyLabelGbc);
                        mainPanel.add(specializedLabel, specializedLabelGbc);
                        mainPanel.add(studentClassLabel, studentClassGbc);
                        mainPanel.add(addGroupButton, addButtonGbc);
                    }
                }
            }
        });
    }
    private void initAllLabel() {
        academyLabel = new JLabel("院校名");
        academyLabel.setFont(new Font("微软雅黑", Font.BOLD, 13));

        academyLabelGbc = new GridBagConstraints();
        academyLabelGbc.gridx = 0;
        academyLabelGbc.gridy = 2;
        academyLabelGbc.gridheight = 1;
        academyLabelGbc.gridwidth = 1;

        specializedLabel = new JLabel("专业名");
        specializedLabel.setFont(new Font("微软雅黑", Font.BOLD, 13));

        specializedLabelGbc = new GridBagConstraints();
        specializedLabelGbc.gridx = 0;
        specializedLabelGbc.gridy = 3;
        specializedLabelGbc.gridheight = 1;
        specializedLabelGbc.gridwidth = 1;

        studentClassLabel = new JLabel("班级名");
        studentClassLabel.setFont(new Font("微软雅黑", Font.BOLD, 13));

        studentClassGbc = new GridBagConstraints();
        studentClassGbc.gridx = 0;
        studentClassGbc.gridy = 4;
        studentClassGbc.gridwidth = 1;
        studentClassGbc.gridheight = 1;
    }
    // 将除去选择添加组的comboBox和label全部出栈
    private void removeComponent() {
        if (addGroupField != null)
            mainPanel.remove(addGroupField);
        if (selectComboBox1 != null)
            mainPanel.remove(selectComboBox1);
        if (selectComboBox2 != null)
            mainPanel.remove(selectComboBox2);
        if (addGroupButton != null) {
            mainPanel.remove(addGroupButton);
        }
        mainPanel.remove(academyLabel);
        mainPanel.remove(specializedLabel);
        mainPanel.remove(studentClassLabel);

        mainPanel.repaint();
    }
    // 刷新侧栏树
    private void resetTree() {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
        // 获取院校
        java.util.List<String> academyList = dao.getAcademy();

        Map<String, java.util.List<String>> specializedList = new HashMap<>();
        Map<String, java.util.List<String>> studentClassList = new HashMap<>();

        // 获取专业
        for (String item : academyList) {
            specializedList.put(item, dao.getSpecialized(item));
        }
        // 获取班级
        for (java.util.List<String> items : specializedList.values()) {
            for (String item : items) {
                studentClassList.put(item, dao.getStudentClass(item));
            }
        }
        java.util.List<DefaultMutableTreeNode> academyTree = new ArrayList<>();

        for (String academy : academyList) {
            DefaultMutableTreeNode academyNode = new DefaultMutableTreeNode(academy);
            academyTree.add(academyNode);

            // 获取该学院下的专业列表
            java.util.List<String> specializedListForAcademy = specializedList.get(academy);

            // 遍历专业列表
            for (String specialized : specializedListForAcademy) {
                DefaultMutableTreeNode specializedNode = new DefaultMutableTreeNode(specialized);
                academyNode.add(specializedNode);

                // 获取该专业下的班级列表
                List<String> studentClassListForSpecialized = studentClassList.get(specialized);

                // 遍历班级列表
                for (String studentClass : studentClassListForSpecialized) {
                    DefaultMutableTreeNode studentClassNode = new DefaultMutableTreeNode(studentClass);
                    specializedNode.add(studentClassNode);
                }
            }
        }

        for (DefaultMutableTreeNode node : academyTree) {
            root.add(node);
        }

        Main.studentMain.leftMenu.root = root;
        Main.studentMain.leftMenu.model.setRoot(root);
    }
}
