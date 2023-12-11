package com.nocl.studentmanager.utils;

import com.nocl.studentmanager.database.bean.Account;
import com.nocl.studentmanager.database.dao.AccountDAO;
import com.nocl.studentmanager.database.utils.ConnectDatabase;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class LoginBehavior {
    private String Username;
    private String Password;
    private SqlSession sqlSession;
    private AccountDAO dao;
    public LoginBehavior(String Username, String Password) {
        this.Username = Username;
        this.Password = Password;
        sqlSession = ConnectDatabase.getSqlSessionFactory();
        dao = sqlSession.getMapper(AccountDAO.class);
    }

    public boolean login() {
        System.out.println(dao.getAccount(Username, Password));
        System.out.println(dao.getAccount(Username, Password).isUserAdmin());
        return true;
    }


}
