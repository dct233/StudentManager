package com.nocl.studentmanager.view.main.layout;

import java.util.ArrayList;
import java.util.List;

import com.alee.laf.menu.WebMenuItem;
import com.alee.utils.swing.menu.MenuBarGenerator;
import com.alee.utils.swing.menu.PopupMenuGenerator;
import com.nocl.studentmanager.Main;
import com.nocl.studentmanager.view.main.ddl.AddStudentInfo;
import jdk.jfr.Frequency;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static com.nocl.studentmanager.Main.frame;
import static com.nocl.studentmanager.Main.studentMain;

public class TopMenu extends JPanel {
    private final GridBagConstraints gbc;
    private PopupMenuGenerator menu;
    private MenuBarGenerator topMenu;
    // private JMenu info;
    // private JMenu operate;

    public TopMenu() {
        // 容器内布局设置
        GridBagLayout layout = new GridBagLayout();
        layout.columnWidths = new int[1];
        layout.rowHeights = new int[2];
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
        //initTabbedPane();
        initMenuBar();
        initPopupMenu();
        /*
        initMenuBar();
        initTitle();
        */

    }

    private void initMenuBar() {
        topMenu = new MenuBarGenerator();
        // 容器字号 中文: 12像素 字母: 7像素 符号(包括空格): 3像素
        List<String> items = new ArrayList<>() {{
            add("添加...");
            add("删除...");
            add("退出系统");
        }};
        // 添加
        topMenu.addItem(items.get(0), e -> menu.getMenu().showBelowMiddle((Component) e.getSource()));
        // 删除选项
        topMenu.addItem(items.get(1), false, null);
        // 退出系统
        topMenu.addItem(items.get(2), null);
        topMenu.getMenu().setForeground(new Color(63,81,181));

        topMenu.getMenu().addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                int width = studentMain.topMenu.getWidth() ;
                int space = topMenu.getMenu().getGraphics().getFontMetrics().charWidth(' ');
                for (String item : items) {
                    width -= topMenu.getMenu().getGraphics().getFontMetrics().stringWidth(item);
                }
                if (topMenu.getMenu().getComponentCount() != items.size()) {
                    topMenu.getMenu().remove(topMenu.getMenu().getComponentCount() - 2);
                }
                topMenu.getMenu().add(new WebMenuItem(" ".repeat(width / space)) {{ setEnabled(false); }}, topMenu.getMenu().getComponentCount() - 1);
                topMenu.getMenu().revalidate();
            }
        });

        frame.addWindowStateListener(new WindowAdapter() {
            @Override
            public void windowStateChanged(WindowEvent e) {
                super.windowStateChanged(e);
                WebMenuItem component = (WebMenuItem) topMenu.getMenu().getComponent(topMenu.getMenu().getComponentCount() - 1);
                component.doClick();
            }
        });

        GridBagConstraints buttonGbr = new GridBagConstraints();
        buttonGbr.insets = new Insets(0, 0, 0,0);
        buttonGbr.fill = GridBagConstraints.BOTH;
        buttonGbr.gridx = 0;
        buttonGbr.gridy = 0;
        buttonGbr.gridheight = 1;
        buttonGbr.gridwidth = 1;

        this.add(topMenu.getMenu(), buttonGbr);
    }
    // 第三版菜单栏
    /*private void initTabbedPane() {
        JPanel panel = new JPanel(false);

        GridBagLayout layout = new GridBagLayout();
        layout.columnWidths = new int[10];
        layout.rowHeights = new int[1];
        layout.columnWeights = new double[] {0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1};
        layout.rowWeights = new double[] {1.0};

        panel.setLayout(layout);
        JButton button = new JButton("添加...");
        //JButton button = new JButton();
        //button.setStyleId(StyleId.of("custom"));
        button.addMouseListener(new TopMenuListener().getAdd());
        button.setFont(new Font("微软雅黑", Font.PLAIN, 15));

        button.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(final ActionEvent e) {
                menu.getMenu().showBelowMiddle((Component) e.getSource());
                Main.studentMain.resetPanel();
            }
        });

        GridBagConstraints buttonGbr = new GridBagConstraints();
        buttonGbr.insets = new Insets(0, 5, 5 ,5);
        buttonGbr.fill = GridBagConstraints.NONE;
        buttonGbr.anchor = GridBagConstraints.LINE_START;
        buttonGbr.gridx = 0;
        buttonGbr.gridy = 1;
        buttonGbr.gridheight = 1;
        buttonGbr.gridwidth = 1;

        panel.add(button, buttonGbr);

        GridBagConstraints panelGbc = new GridBagConstraints();
        panelGbc.insets = new Insets(0,0,0,0);
        panelGbc.fill = GridBagConstraints.BOTH;
        panelGbc.gridx = 0;
        panelGbc.gridy = 0;
        panelGbc.gridheight = 1;
        panelGbc.gridwidth = 1;

        this.add(panel, panelGbc);
    }*/
    // 利用 Weblaf 快速创建菜单栏
    private void initPopupMenu() {
        menu = new PopupMenuGenerator();
        menu.setIconSettings ( "resources/icons", ".png" );
        menu.setLanguagePrefix ( "StudentMain.TopMenu.menu" );
        menu.getMenu().setFont(new Font("微软雅黑", Font.BOLD, 15));

        menu.addItem ( "add16", "add", e -> {
            AddStudentInfo addStudentInfo = new AddStudentInfo(Main.frame);
            addStudentInfo.setLocationRelativeTo(Main.frame);
            addStudentInfo.setModal(true);
            addStudentInfo.setVisible(true);
            /*NotificationManager.showNotification ( "StudentMain.TopMenu.menu.add" );*/
        });
    }
    // 第二版菜单栏
    /*private void initTabbedPane() {
        *//*JTabbedPane menu = new JTabbedPane(SwingConstants.TOP);*//*
        JPopupMenu menu = new JPopupMenu();
        //WebTabbedPane menu = new WebTabbedPane(SwingConstants.TOP);

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
        //JButton button = new JButton();
        //button.setStyleId(StyleId.of("custom"));
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

        *//*menu.addTab("添加", panel);
        menu.setFont(new Font("微软雅黑", Font.BOLD, 14));*//*

        GridBagConstraints menuGbc = new GridBagConstraints();
        menuGbc.insets = new Insets(0,0,0,0);
        menuGbc.fill = GridBagConstraints.BOTH;
        menuGbc.gridx = 0;
        menuGbc.gridy = 0;
        menuGbc.gridheight = 1;
        menuGbc.gridwidth = 1;

        this.add(menu, menuGbc);
    }*/
    // 第一版菜单栏
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

    public GridBagConstraints getGbc() {
        return gbc;
    }

    public MenuBarGenerator getTopMenu() {
        return topMenu;
    }
}
