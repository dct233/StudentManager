package com.nocl.studentmanager;

import com.nocl.studentmanager.gui.main.StudentMain;
import com.nocl.studentmanager.listener.LoginButtonListener;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("登录");
        frame.setContentPane(new StudentMain().InitMainPanel());
        //frame.setContentPane(new Login().getRoot());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280, 720);
        // 登录控件
        //frame.setSize(350, 300);
        //frame.setResizable(false);

        // 在控件失焦时提供回车登录事件监听
        frame.addKeyListener(new LoginButtonListener().getKeyListener());
        frame.setVisible(true);
    }
}
