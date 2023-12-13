package com.nocl.studentmanager.gui.main.layout;

import javax.swing.*;
import java.awt.*;

public class TopMenu extends JPanel{
    private final GridBagConstraints gbc;
    private JMenuBar menuBar;
    private JMenu info;

    public TopMenu() {
        // 容器内布局设置
        GridBagLayout layout = new GridBagLayout();
        layout.columnWidths = new int[1];
        layout.rowHeights = new int[2];
        layout.columnWeights = new double[] {1.0};
        layout.rowWeights = new double[] {0.01, 0.94};
        this.setLayout(layout);
        // 背景颜色
        this.setBackground(new Color(64,84,180));
        // 外部布局设置
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 0, 5, 0);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        // 初始化内部容器组件
        initMenuBar();
        initTitle();
    }

    private void initMenuBar() {
        menuBar = new JMenuBar();
        info = new JMenu("Info");
        menuBar.setFont(new Font("微软雅黑", Font.PLAIN, 8));
        // 添加菜单
        menuBar.add(info);
        // TODO: 2023/12/13 子菜单添加位置 
        // 设置菜单布局
        GridBagConstraints menuGbc = new GridBagConstraints();
        menuGbc.insets = new Insets(0,0,0,0);
        menuGbc.fill = GridBagConstraints.BOTH;
        menuGbc.gridx = 0;
        menuGbc.gridy = 0;
        menuGbc.gridheight = 1;
        menuGbc.gridwidth = 1;

        this.add(menuBar, menuGbc);
    }

    private void initTitle() {
        JLabel title = new JLabel("学生管理系统");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("微软雅黑", Font.BOLD, 18));

        GridBagConstraints titleGbc = new GridBagConstraints();
        titleGbc.insets = new Insets(0 , 10, 0 ,0);
        titleGbc.fill = GridBagConstraints.BOTH;
        titleGbc.gridx = 0;
        titleGbc.gridy = 1;
        titleGbc.gridheight = 1;
        titleGbc.gridwidth = 1;

        this.add(title, titleGbc);
    }

    public GridBagConstraints getGbc() {
        return gbc;
    }
}
