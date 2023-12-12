package com.nocl.studentmanager.gui;

import com.nocl.studentmanager.listener.LoginButtonListener;
import javax.swing.*;

public class Login {
    public Login() {
        // 点击登录按钮监听
        loginButton.addMouseListener(new LoginButtonListener(usernameField, passwordField).getMouseListener());
        // 为登录界面三个控件提供回车登录事件监听
        loginButton.addKeyListener(new LoginButtonListener(usernameField, passwordField).getKeyListener());
        usernameField.addKeyListener(new LoginButtonListener(usernameField, passwordField).getKeyListener());
        passwordField.addKeyListener(new LoginButtonListener(usernameField, passwordField).getKeyListener());
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
