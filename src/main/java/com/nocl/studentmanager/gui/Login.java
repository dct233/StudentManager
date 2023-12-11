package com.nocl.studentmanager.gui;

import com.nocl.studentmanager.listener.LoginButtonListener;
import javax.swing.*;

public class Login {
    public Login() {
        // 点击登录按钮监听
        loginButton.addMouseListener(new LoginButtonListener(textField1, passwordField1).getMouseListener());
        // 为登录界面三个控件提供回车登录事件监听
        loginButton.addKeyListener(new LoginButtonListener(textField1, passwordField1).getKeyListener());
        textField1.addKeyListener(new LoginButtonListener(textField1, passwordField1).getKeyListener());
        passwordField1.addKeyListener(new LoginButtonListener(textField1, passwordField1).getKeyListener());
    }

    public JPanel getRoot() {
        return root;
    }
    public JTextField getTextField1() {
        return textField1;
    }

    public JPasswordField getPasswordField1() {
        return passwordField1;
    }

    private JPanel root;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton loginButton;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JLabel tableLabel;

}
