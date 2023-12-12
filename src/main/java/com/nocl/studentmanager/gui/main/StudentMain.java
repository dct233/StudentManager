package com.nocl.studentmanager.gui.main;

import com.nocl.studentmanager.gui.main.layout.*;

import javax.swing.*;
import java.awt.*;

public class StudentMain {
    private JPanel Panel;

    public StudentMain() {
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[3];  // 列
        gridBagLayout.rowHeights = new int[3];  // 行
        gridBagLayout.columnWeights = new double[] {0.1, 0.7, 0.2}; // 列占比
        gridBagLayout.rowWeights = new double[] {0.05, 0.475, 0.475}; // 行占比
        Panel = new JPanel(gridBagLayout);
    }

    public JPanel InitMainPanel() {
        // 顶栏容器
        TopMenu topMenu = new TopMenu();
        // 左侧边栏
        LeftMenu leftMenu = new LeftMenu();
        // 表格区域
        StudentXLS studentXLS = new StudentXLS();
        // 右中区域
        UtilsMenu utilsMenu = new UtilsMenu();
        // Log区域
        Logger logger = new Logger();

        Panel.add(topMenu, topMenu.getGbc());
        Panel.add(leftMenu, leftMenu.getGbc());
        Panel.add(studentXLS, studentXLS.getGbc());
        Panel.add(utilsMenu, utilsMenu.getGbc());
        Panel.add(logger, logger.getGbc());

        return Panel;
    }
}
