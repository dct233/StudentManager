package com.nocl.studentmanager.gui;

import com.nocl.studentmanager.listener.LoginButtonListener;
import javax.swing.*;

public class Login {
    public Login() {
        // 点击登录按钮监听
        loginButton.addMouseListener(new LoginButtonListener().getMouseListener());
        // 为登录界面三个控件提供回车登录事件监听
        loginButton.addKeyListener(new LoginButtonListener().getKeyListener());
        textField1.addKeyListener(new LoginButtonListener().getKeyListener());
        passwordField1.addKeyListener(new LoginButtonListener().getKeyListener());
    }

    public JPanel getRoot() {
        return root;
    }

    private JPanel root;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton loginButton;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JLabel tableLabel;

}
