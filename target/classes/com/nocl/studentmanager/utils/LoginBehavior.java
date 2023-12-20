package com.nocl.studentmanager.utils;

import com.nocl.studentmanager.Main;
import com.nocl.studentmanager.database.dao.AccountDAO;
import com.nocl.studentmanager.database.utils.ConnectDatabase;
import com.nocl.studentmanager.view.main.StudentMain;
import org.apache.ibatis.session.SqlSession;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;

public class LoginBehavior {
    private final String Username;
    private final String Password;
    private final SqlSession sqlSession;
    private final AccountDAO dao;
    public LoginBehavior(String Username, String Password) {
        this.Username = Username;
        this.Password = Password;
        sqlSession = ConnectDatabase.getSqlSessionFactory();
        dao = sqlSession.getMapper(AccountDAO.class);
    }

    public void startLogin() {
        if (searchAccount()) {
            // 登录成功, 并关闭数据库连接
            JOptionPane.showOptionDialog(Main.frame, "登录成功, 即将跳转到管理系统", "登录成功", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"确定"}, null);
            sqlSession.close();
            // 启动管理系统
            Main.frame.setVisible(false);
            Main.frame.setResizable(true);
            Main.frame.setTitle("学生管理系统");
            Main.frame.setSize(1600, 800);
            Main.frame.setExtendedState(Frame.MAXIMIZED_BOTH);
            Main.studentMain = new StudentMain();
            Main.frame.setContentPane(Main.studentMain.InitMainPanel());
            Main.frame.setVisible(true);
        } else {
            // 登录失败
            JOptionPane.showOptionDialog(Main.frame, "登录失败, 请检查你的用户名或密码", "登录失败", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, new Object[]{"确定"}, null);
        }
    }
    // 查询数据库账号以及密码
    public boolean searchAccount() {
        return dao.getAccount(Username, Password) != null;
    }
}
