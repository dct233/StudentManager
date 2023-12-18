package com.nocl.studentmanager.view.main.layout;

import com.nocl.studentmanager.Main;
import com.nocl.studentmanager.view.main.utils.StudentXLSUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import java.awt.*;
import java.util.Map;

import static com.nocl.studentmanager.view.main.StudentMain.dao;

public class LeftMenu extends JPanel {
    private final GridBagConstraints gbc;
    private JLabel add;
    private JTree tree;

    public LeftMenu() {
        GridBagLayout layout = new GridBagLayout();
        layout.columnWidths = new int[1];
        layout.rowHeights = new int[2];
        layout.columnWeights = new double[] {1.0};
        layout.rowWeights = new double[] {0.1, 0.9};
        this.setLayout(layout);

        //this.setBackground(Color.CYAN);

        gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 0, 5, 0);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 2;
        initLabel();
        initTree();
    }
    private void initLabel() {
        add = new JLabel("                                       ");
        add.setFont(new Font("微软雅黑", Font.BOLD, 16));
        //add.addMouseListener(new LeftMenuListener(StudentMain.studentXLS.getModel()).getAdd());

        GridBagConstraints addGbc = new GridBagConstraints();
        addGbc.gridx = 0;
        addGbc.gridy = 0;
        addGbc.gridwidth = 1;
        addGbc.gridheight = 1;

        this.add(add, addGbc);
    }

    private void initTree() {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
        // 获取院校
        List<String> academyList = dao.getAcademy();

        Map<String, List<String>> specializedList = new HashMap<>();
        Map<String, List<String>> studentClassList = new HashMap<>();

        // 获取专业
        for (String item : academyList) {
            specializedList.put(item, dao.getSpecialized(item));
        }
        // 获取班级
        for (List<String> items : specializedList.values()) {
            for (String item : items) {
                studentClassList.put(item, dao.getStudentClass(item));
            }
        }
        /*List<DefaultMutableTreeNode> academyTree = new ArrayList<>() {{
            for (Map.Entry<String, List<String>> entry : specializedList.entrySet()) {
                // 根据学院名称创建出容器
                DefaultMutableTreeNode childTree = new DefaultMutableTreeNode(entry.getKey());
                for (Map.Entry<String, List<String>> studentEntry : studentClassList.entrySet()) {

                    DefaultMutableTreeNode studentTree = new DefaultMutableTreeNode(studentEntry.getKey());
                    childTree.add(studentTree);
                    for (String item : studentEntry.getValue()) {
                        studentTree.add(new DefaultMutableTreeNode(item));
                    }
                }
                add(childTree);
            }
        }};*/
        List<DefaultMutableTreeNode> academyTree = new ArrayList<>();

        for (String academy : academyList) {
            DefaultMutableTreeNode academyNode = new DefaultMutableTreeNode(academy);
            academyTree.add(academyNode);

            // 获取该学院下的专业列表
            List<String> specializedListForAcademy = specializedList.get(academy);

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

        tree = new JTree(root);

        tree.addTreeSelectionListener(e -> {
            if (e.getSource() == tree) {
                DefaultMutableTreeNode dmt = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
                if (dmt.isRoot()) {
                    Main.studentMain.studentXLS.setModel(StudentXLSUtils.setStudentTable(dao.getStudentInfo(null)));
                    return;
                }
                Main.studentMain.studentXLS.setModel(StudentXLSUtils.setStudentTable(dao.getTreeList('%' + dmt.getUserObject().toString() + '%')));
            }
        });

        GridBagConstraints treeGbc = new GridBagConstraints();
        treeGbc.fill = GridBagConstraints.BOTH;
        treeGbc.gridx = 0;
        treeGbc.gridy = 0;
        treeGbc.gridwidth = 1;
        treeGbc.gridheight = 2;

        this.add(tree, treeGbc);
    }

    public GridBagConstraints getGbc() {
        return gbc;
    }
}
