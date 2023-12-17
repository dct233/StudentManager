package com.nocl.studentmanager.utils;

import com.nocl.studentmanager.database.dao.AccountDAO;
import com.nocl.studentmanager.database.utils.ConnectDatabase;
import org.apache.ibatis.session.SqlSession;

import javax.swing.*;

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
            JOptionPane.showMessageDialog(null, "登录成功", "TODO", JOptionPane.INFORMATION_MESSAGE);
            sqlSession.close();
        } else {
            // 登录失败
            JOptionPane.showMessageDialog(null, "请检查你的用户名或密码", "登录失败", JOptionPane.WARNING_MESSAGE);
        }
    }
    // 查询数据库账号以及密码
    public boolean searchAccount() {
        return dao.getAccount(Username, Password) != null;
    }
}
