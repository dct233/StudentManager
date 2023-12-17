package com.nocl.studentmanager.view.main.layout;

import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;

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
        List<DefaultMutableTreeNode> academyTree = new ArrayList<>() {{
            for (String item : dao.getAcademy()) {
                add(new DefaultMutableTreeNode(item));
            }
        }};
        for (DefaultMutableTreeNode node : academyTree) {
            root.add(node);
        }
        tree = new JTree(root);

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
