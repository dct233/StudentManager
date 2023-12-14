package com.nocl.studentmanager;

import com.mysql.cj.Session;
import com.nocl.studentmanager.database.bean.Student;
import com.nocl.studentmanager.database.dao.AccountDAO;
import com.nocl.studentmanager.database.dao.StudentInfoDAO;
import com.nocl.studentmanager.database.utils.ConnectDatabase;
import com.nocl.studentmanager.gui.main.StudentMain;
import com.nocl.studentmanager.listener.LoginButtonListener;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;

public class Main {
    public static final Logger LOGGER = LogManager.getLogger(Main.class);
    public static JFrame frame = new JFrame("登录");

    public static void main(String[] args) {

        StudentMain studentMain = new StudentMain();
        frame.setContentPane(studentMain.InitMainPanel());
        //frame.setContentPane(new Login().getRoot());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280, 720);
        // 登录控件
        //frame.setSize(350, 300);
        //frame.setResizable(false);

        // 在控件失焦时提供回车登录事件监听
        frame.addKeyListener(new LoginButtonListener().getKeyListener());
        frame.setVisible(true);

        LOGGER.info("Nocl");
    }
}
