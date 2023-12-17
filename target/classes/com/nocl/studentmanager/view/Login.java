package com.nocl.studentmanager.view;

import com.nocl.studentmanager.listener.LoginButtonAdapter;

import javax.swing.*;

public class Login {
    public Login() {
        // 点击登录按钮监听
        //loginButton.addMouseListener(new LoginButtonListener(usernameField, passwordField).getMouseListener());
        loginButton.addMouseListener(new LoginButtonAdapter(usernameField, passwordField));
        // 为登录界面三个控件提供回车登录事件监听
        loginButton.addKeyListener(new LoginButtonAdapter(usernameField, passwordField));
        usernameField.addKeyListener(new LoginButtonAdapter(usernameField, passwordField));
        passwordField.addKeyListener(new LoginButtonAdapter(usernameField, passwordField));
    }

    public JPanel getRoot() {
        return root;
    }
    public JTextField getTextField1() {
        return usernameField;
    }

    public JPasswordField getPasswordField1() {
        return passwordField;
    }

    private JPanel root;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JLabel tableLabel;
    private JButton registerButton;

}
