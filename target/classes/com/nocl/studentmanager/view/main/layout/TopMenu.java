package com.nocl.studentmanager.view.main.layout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.alee.laf.menu.WebMenuItem;
import com.alee.utils.swing.menu.MenuBarGenerator;
import com.alee.utils.swing.menu.PopupMenuGenerator;
import com.nocl.studentmanager.Main;
import com.nocl.studentmanager.view.Login;
import com.nocl.studentmanager.view.main.ddl.AddStudentInfo;
import jdk.jfr.Frequency;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

import static com.nocl.studentmanager.Main.frame;
import static com.nocl.studentmanager.Main.studentMain;
import static com.nocl.studentmanager.view.main.StudentMain.dao;
import static com.nocl.studentmanager.view.main.StudentMain.sqlSession;
import static javax.swing.JOptionPane.QUESTION_MESSAGE;

public class TopMenu extends JPanel {
    private final GridBagConstraints gbc;
    private PopupMenuGenerator addMenuPopup;
    private PopupMenuGenerator exitMenuPopup;
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
        initAddPopupMenu();
        initExitPopupMenu();
        /*
        initMenuBar();
        initTitle();
        */

    }

    private void initMenuBar() {
        topMenu = new MenuBarGenerator();
        topMenu.setIconSettings ( "resources/icons", ".png" );
        // 容器字号 中文: 12像素 字母: 7像素 符号(包括空格): 3像素
        List<String> items = new ArrayList<>() {{
            add("添加...");
            add("删除所选条目");
            add("退出系统");
        }};
        // 添加
        topMenu.addItem("add16", items.get(0), e -> addMenuPopup.getMenu().showBelowMiddle((Component) e.getSource()));
        // 删除选项
        topMenu.addItem("delete16",items.get(1), true, e -> {
            int[] rows = studentMain.studentXLS.getStudentTable().getSelectedRows();
            JTable table = studentMain.studentXLS.getStudentTable();
            DefaultTableModel model = (DefaultTableModel) table.getModel();

            Object[] options = {"确定", "取消"};

            int opt = JOptionPane.showOptionDialog(null, "确认要删除" + rows.length + "条记录?", "删除", JOptionPane.YES_NO_OPTION, QUESTION_MESSAGE, null, options, options[1]);

            if (opt == JOptionPane.YES_OPTION) {
                for (int i = rows.length - 1; i >= 0; i--) {
                    int viewRow = rows[i];
                    int modelRow = table.convertRowIndexToModel(viewRow);
                    dao.deleteStudentInfo(Integer.valueOf((String) model.getValueAt(modelRow, 0)));
                    model.removeRow(modelRow);
                    sqlSession.commit();
                }
            }
        });
        // 退出系统
        topMenu.addItem("exit16", items.get(2), e -> exitMenuPopup.getMenu().showBelowMiddle((Component) e.getSource()));
        topMenu.getMenu().setForeground(new Color(63,81,181));


        topMenu.getMenu().addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                int width = studentMain.topMenu.getWidth() - 80;
                int space = topMenu.getMenu().getGraphics().getFontMetrics().charWidth(' ');
                for (String item : items) {
                    width -= topMenu.getMenu().getGraphics().getFontMetrics().stringWidth(item);
                }
                if (topMenu.getMenu().getComponentCount() != items.size()) {
                    topMenu.getMenu().remove(topMenu.getMenu().getComponentCount() - 2);
                }
                topMenu.getMenu().add(new WebMenuItem(" ".repeat(width / space)) {{ setEnabled(false); }}, topMenu.getMenu().getComponentCount() - 1);
                studentMain.topMenu.setMaximumSize(new Dimension(studentMain.topMenu.getWidth(), 30));
                topMenu.getMenu().revalidate();
            }
        });

        /*frame.addWindowStateListener(new WindowAdapter() {
            @Override
            public void windowStateChanged(WindowEvent e) {
                super.windowStateChanged(e);
                WebMenuItem component = (WebMenuItem) topMenu.getMenu().getComponent(topMenu.getMenu().getComponentCount() - 1);
                component.doClick();
            }
        });*/

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
    private void initAddPopupMenu() {
        addMenuPopup = new PopupMenuGenerator();
        addMenuPopup.setIconSettings ("resources/icons", ".png");
        addMenuPopup.setLanguagePrefix ("StudentMain.TopMenu.menu");
        addMenuPopup.getMenu().setFont(new Font("微软雅黑", Font.BOLD, 15));

        addMenuPopup.addItem ( "add16", "add", e -> {
            AddStudentInfo addStudentInfo = new AddStudentInfo(Main.frame);
            addStudentInfo.setLocationRelativeTo(Main.frame);
            addStudentInfo.setModal(true);
            addStudentInfo.setVisible(true);
            /*NotificationManager.showNotification ( "StudentMain.TopMenu.menu.add" );*/
        });
        addMenuPopup.addItem("add16", "group", null);
    }
    private void initExitPopupMenu() {
        exitMenuPopup = new PopupMenuGenerator();
        exitMenuPopup.setIconSettings("resources/icons", ".png");
        exitMenuPopup.setLanguagePrefix("StudentMain.TopMenu.menu");
        exitMenuPopup.getMenu().setFont(new Font("微软雅黑", Font.BOLD, 15));

        exitMenuPopup.addItem("exit16", "ExitA", e -> {
            frame.setExtendedState(Frame.NORMAL);
            frame.setSize(350, 300);
            frame.setVisible(false);
            frame.setTitle("登录");
            frame.setResizable(false);
            frame.setContentPane(new Login().getRoot());
            frame.setVisible(true);
        });
        exitMenuPopup.addItem("exit16", "ExitS", e -> System.exit(0));
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
