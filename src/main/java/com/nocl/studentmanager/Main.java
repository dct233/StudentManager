package com.nocl.studentmanager;

import com.nocl.studentmanager.gui.Login;
import com.nocl.studentmanager.listener.LoginButtonListener;
import com.nocl.studentmanager.utils.LoginBehavior;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("登录");
        frame.setContentPane(new Login().getRoot());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setResizable(false);
        // 在控件失焦时提供回车登录事件监听
        frame.addKeyListener(new LoginButtonListener().getKeyListener());
        frame.setVisible(true);
    }
}
