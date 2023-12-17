package com.nocl.studentmanager.database.bean;

public class Account {
    private String Username;
    private String Password;
    private Integer admin;

    public boolean isUserAdmin() {
        return admin == 1;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Integer getAdmin() {
        return admin;
    }

    public void setAdmin(Integer admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "Account{" +
                "Username='" + Username + '\'' +
                ", Password='" + Password + '\'' +
                ", admin=" + admin +
                '}';
    }
}
