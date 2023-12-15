package com.nocl.studentmanager.gui.main;

import com.nocl.studentmanager.Main;
import com.nocl.studentmanager.database.dao.StudentInfoDAO;
import com.nocl.studentmanager.database.utils.ConnectDatabase;
import com.nocl.studentmanager.gui.main.ddl.AddStudentInfo;
import com.nocl.studentmanager.gui.main.layout.*;
import org.apache.ibatis.session.SqlSession;

import javax.swing.*;
import java.awt.*;

public class StudentMain {
    private JPanel Panel;
    public static SqlSession sqlSession = ConnectDatabase.getSqlSessionFactory();
    public static StudentInfoDAO dao = sqlSession.getMapper(StudentInfoDAO.class);
    // 表格区域
    public static StudentXLS studentXLS = new StudentXLS();
    // 顶栏容器
    public static TopMenu topMenu = new TopMenu();
    // 左侧边栏
    public static LeftMenu leftMenu = new LeftMenu();
    // 右中区域
    public static UtilsMenu utilsMenu = new UtilsMenu();
    // Log区域
    public static Logger logger = new Logger();

    public StudentMain() {
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[3];  // 列
        gridBagLayout.rowHeights = new int[3];  // 行
        gridBagLayout.columnWeights = new double[] {0.1, 0.7, 0.2}; // 列占比
        gridBagLayout.rowWeights = new double[] {0.05, 0.475, 0.475}; // 行占比
        Panel = new JPanel(gridBagLayout);
    }

    public JPanel InitMainPanel() {
        Panel.add(topMenu, topMenu.getGbc());
        Panel.add(leftMenu, leftMenu.getGbc());
        Panel.add(studentXLS, studentXLS.getGbc());
        Panel.add(utilsMenu, utilsMenu.getGbc());
        Panel.add(logger, logger.getGbc());

        return Panel;
    }
}
