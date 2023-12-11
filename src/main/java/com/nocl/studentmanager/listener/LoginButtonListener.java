package com.nocl.studentmanager.listener;

import com.nocl.studentmanager.listener.abstracts.LoginButtonAdapter;
import com.nocl.studentmanager.utils.LoginBehavior;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginButtonListener {
    static class LoginMouseListener extends LoginButtonAdapter {
        public LoginMouseListener(JTextField username, JTextField password) {
            super(username, password);
        }
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            LoginBehavior loginBehavior = new LoginBehavior(
                    super.getUsername().getText(),
                    super.getPassword().getText()
            );
            loginBehavior.login();
        }
    }
    static class LoginKeyListener extends LoginButtonAdapter {
        public LoginKeyListener(JTextField username, JTextField password) {
            super(username, password);
        }
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            if (e.getKeyChar() == '\n') {
                LoginBehavior loginBehavior = new LoginBehavior(
                        super.getUsername().getText(),
                        super.getPassword().getText()
                );
                loginBehavior.login();
            }
        }
    }

    private LoginMouseListener mouseListener;
    private LoginKeyListener keyListener;

    public LoginButtonListener() {}
    public LoginButtonListener(JTextField username, JTextField password) {
        mouseListener = new LoginMouseListener(username, password);
        keyListener = new LoginKeyListener(username, password);
    }

    public LoginMouseListener getMouseListener() {
        return mouseListener;
    }

    public LoginKeyListener getKeyListener() {
        return keyListener;
    }
}