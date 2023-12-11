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
        if (login()) {
            // TODO: 2023/12/12 登录成功后逻辑
            JOptionPane.showMessageDialog(null, "登录成功", "TODO", JOptionPane.INFORMATION_MESSAGE);
            sqlSession.close();
        } else {
            JOptionPane.showMessageDialog(null, "请检查你的用户名或密码", "登录失败", JOptionPane.WARNING_MESSAGE);
        }
    }

    public boolean login() {
        return dao.getAccount(Username, Password) != null;
    }
}
