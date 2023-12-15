package com.nocl.studentmanager;

import com.mysql.cj.Session;
import com.nocl.studentmanager.database.bean.Student;
import com.nocl.studentmanager.database.dao.AccountDAO;
import com.nocl.studentmanager.database.dao.StudentInfoDAO;
import com.nocl.studentmanager.database.utils.ConnectDatabase;
import com.nocl.studentmanager.gui.main.StudentMain;
import com.nocl.studentmanager.gui.main.ddl.AddStudentInfo;
import com.nocl.studentmanager.listener.LoginButtonListener;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;

import static com.nocl.studentmanager.gui.main.StudentMain.dao;

public class Main {
    public static final Logger LOGGER = LogManager.getLogger(Main.class);
    public static JFrame frame = new JFrame("登录") {{
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1280, 720);
    }};

    public static void main(String[] args) {
        //LOGGER.debug(dao.getStudentClass("物联网信息技术"));
        //frame.setContentPane(new Login().getRoot());
        StudentMain studentMain = new StudentMain();
        frame.setVisible(true);
        frame.setContentPane(studentMain.InitMainPanel());
        // 登录控件
        //frame.setSize(350, 300);
        //frame.setResizable(false);

        // 在控件失焦时提供回车登录事件监听
        //frame.addKeyListener(new LoginButtonListener().getKeyListener());

        /*dao.insertStudent(
                "ts",
                17,
                "男",
                "12",
                "123",
                "123",
                "123"
        );*/

        LOGGER.info("Nocl");
    }
}
