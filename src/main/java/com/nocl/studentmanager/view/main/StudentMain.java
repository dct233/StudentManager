package com.nocl.studentmanager.view.main;

import com.nocl.studentmanager.database.dao.StudentInfoDAO;
import com.nocl.studentmanager.database.utils.ConnectDatabase;
import com.nocl.studentmanager.view.main.layout.*;
import org.apache.ibatis.session.SqlSession;

import javax.swing.*;
import java.awt.*;

public class StudentMain {
    public JLayeredPane Panel;
    // 用于主页面全局调用数据库接口
    public static SqlSession sqlSession = ConnectDatabase.getSqlSessionFactory();
    public static StudentInfoDAO dao = sqlSession.getMapper(StudentInfoDAO.class);
    // 表格区域
    public StudentXLS studentXLS;
    // 顶栏容器
    public TopMenu topMenu;
    // 左侧边栏
    public LeftMenu leftMenu;
    // 右中区域
    public BottomMenu bottomMenu;
    // Log区域, 因为日志长度问题会导致布局被挤压, 已弃用, 但仍可用于将Log4j2产生的日志重定向到前端
    public Logger logger;

    private final GridBagLayout MainLayout;

    public StudentMain() {
        studentXLS = new StudentXLS();
        topMenu = new TopMenu();
        leftMenu = new LeftMenu();
        bottomMenu = new BottomMenu();
        // 父容器布局设置
        MainLayout = new GridBagLayout();
        MainLayout.columnWidths = new int[3];  // 列
        MainLayout.rowHeights = new int[3];  // 行
        MainLayout.columnWeights = new double[] {0.05, 0.7, 0.2}; // 列占比
        MainLayout.rowWeights = new double[] {0.05, 0.475, 0.475}; // 行占比
        // Panel = new JPanel(gridBagLayout);

        Panel = new JLayeredPane() {{
            setLayout(MainLayout);
        }};
    }
    // 生成主容器提供给frame
    public JLayeredPane InitMainPanel() {
        //JScrollPane scrollPane = new JScrollPane(topMenu);
        JScrollPane scrollPane1 = new JScrollPane(leftMenu);
        JScrollPane scrollPane2 = new JScrollPane(studentXLS);
        JScrollPane scrollPane3 = new JScrollPane(bottomMenu);

        Panel.add(topMenu, topMenu.getGbc(), JLayeredPane.PALETTE_LAYER);
        //Panel.add(new JPanel(), leftMenu.getGbc());
        Panel.add(scrollPane1, leftMenu.getGbc(), 1);
        Panel.add(scrollPane2, studentXLS.getGbc(), 2);
        Panel.add(scrollPane3, bottomMenu.getGbc(), 3);
        //Panel.add(scrollPane4, logger.getGbc(), 4);

        return Panel;
    }
}
