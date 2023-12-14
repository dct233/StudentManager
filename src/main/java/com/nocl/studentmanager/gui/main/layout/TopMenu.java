package com.nocl.studentmanager.gui.main.layout;

import com.nocl.studentmanager.gui.main.StudentMain;
import com.nocl.studentmanager.gui.main.listener.LeftMenuListener;
import com.nocl.studentmanager.gui.main.listener.TopMenuListener;

import javax.swing.*;
import java.awt.*;

public class TopMenu extends JPanel{
    private final GridBagConstraints gbc;
    private JPopupMenu menuBar;
    private JMenu info;
    private JMenu operate;

    public TopMenu() {
        // 容器内布局设置
        GridBagLayout layout = new GridBagLayout();
        layout.columnWidths = new int[1];
        layout.rowHeights = new int[1];
        layout.columnWeights = new double[] {1.0};
        layout.rowWeights = new double[] {1.0};
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
        initTabbedPane();
        //initMenuBar();
        //initTitle();
    }
    private void initTabbedPane() {
        JTabbedPane menu = new JTabbedPane(SwingConstants.TOP);

        JPanel panel = new JPanel(false);
        //JLabel filler=new JLabel("test");
        //filler.setHorizontalAlignment(JLabel.CENTER);
        //panel.setLayout(new GridLayout(1,1));
        //panel.add(filler);

        GridBagLayout layout = new GridBagLayout();
        layout.columnWidths = new int[10];
        layout.rowHeights = new int[1];
        layout.columnWeights = new double[] {0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1};
        layout.rowWeights = new double[] {1.0};

        panel.setLayout(layout);

        JButton button = new JButton("添加学生信息");
        button.addMouseListener(new TopMenuListener(StudentMain.studentXLS.getModel()).getAdd());
        button.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        GridBagConstraints buttonGbr = new GridBagConstraints();
        buttonGbr.insets = new Insets(0, 5, 5 ,5);
        buttonGbr.fill = GridBagConstraints.NONE;
        buttonGbr.anchor = GridBagConstraints.LINE_START;
        buttonGbr.gridx = 0;
        buttonGbr.gridy = 1;
        buttonGbr.gridheight = 1;
        buttonGbr.gridwidth = 1;

        panel.add(button, buttonGbr);

        menu.addTab("添加", panel);
        menu.setFont(new Font("微软雅黑", Font.BOLD, 14));

        GridBagConstraints menuGbc = new GridBagConstraints();
        menuGbc.insets = new Insets(0,0,0,0);
        menuGbc.fill = GridBagConstraints.BOTH;
        menuGbc.gridx = 0;
        menuGbc.gridy = 0;
        menuGbc.gridheight = 1;
        menuGbc.gridwidth = 1;

        this.add(menu, menuGbc);
    }

    /*private void initMenuBar() {
        menuBar = new JPopupMenu("hello");

        info = new JMenu("Info");
        operate = new JMenu("操作");
        // 添加菜单
        JMenu add = new JMenu("添加...");
        JMenuItem addStudent = new JMenuItem("学生");
        addStudent.addMouseListener(new LeftMenuListener(StudentMain.studentXLS.getModel()).getAdd());
        add.add(addStudent);
        operate.add(add);
        menuBar.setFont(new Font("微软雅黑", Font.PLAIN, 8));
        // 添加菜单
        menuBar.add(operate);
        menuBar.add(info);
        // TODO: 2023/12/13 子菜单添加位置
        GridBagLayout layout = new GridBagLayout();
        layout.columnWidths = new int[1];
        layout.rowHeights = new int[1];
        layout.columnWeights = new double[] {1.0};
        layout.rowWeights = new double[] {0.5, 0.5};
        this.setLayout(layout);
        JPanel panel = new JPanel();
        panel.setLayout(layout);
        panel.setBackground(Color.BLUE);
        // 设置菜单布局
        GridBagConstraints menuGbc = new GridBagConstraints();
        menuGbc.insets = new Insets(0,0,0,0);
        menuGbc.fill = GridBagConstraints.BOTH;
        menuGbc.gridx = 0;
        menuGbc.gridy = 0;
        menuGbc.gridheight = 1;
        menuGbc.gridwidth = 1;

        JScrollBar scrollBar = new JScrollBar();
        panel.add(menuBar, menuGbc);

        this.add(panel, menuGbc);
    }*/


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
