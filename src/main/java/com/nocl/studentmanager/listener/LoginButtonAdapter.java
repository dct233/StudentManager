package com.nocl.studentmanager.listener;

import com.nocl.studentmanager.utils.LoginBehavior;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LoginButtonAdapter implements MouseListener, KeyListener {
    private JTextField username;
    private JTextField password;

    public LoginButtonAdapter(JTextField username, JTextField password) {
        this.username = username;
        this.password = password;
    }

    public JTextField getUsername() {
        return username;
    }

    public void setUsername(JTextField username) {
        this.username = username;
    }

    public JTextField getPassword() {
        return password;
    }

    public void setPassword(JTextField password) {
        this.password = password;
    }

    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == '\n') {
            LoginBehavior loginBehavior = new LoginBehavior(
                    username.getText(),
                    password.getText()
            );
            loginBehavior.startLogin();
        }
    }

    public void keyReleased(KeyEvent e) {}

    @Override
    public void mouseClicked(MouseEvent e) {
        LoginBehavior loginBehavior = new LoginBehavior(
                username.getText(),
                password.getText()
        );
        loginBehavior.startLogin();
    }

    public void mousePressed(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {}

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}
}
