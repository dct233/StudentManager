package com.nocl.studentmanager.database.dao;

import com.nocl.studentmanager.database.bean.Account;
import org.apache.ibatis.annotations.Param;

public interface AccountDAO {
    Account getAccount(
            @Param("Username") String Username,
            @Param("Password") String Password
    );
}
