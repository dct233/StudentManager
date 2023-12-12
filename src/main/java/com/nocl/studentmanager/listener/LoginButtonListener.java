package com.nocl.studentmanager.listener;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginButtonListener {
    static class LoginMouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            System.out.println("Mouse Login");
        }
    }
    static class LoginKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            if (e.getKeyChar() == '\n') {
                System.out.println("Enter Login");
            }
        }
    }

    private final LoginMouseListener mouseListener;
    private final LoginKeyListener keyListener;

    public LoginButtonListener() {
        mouseListener = new LoginMouseListener();
        keyListener = new LoginKeyListener();
    }


    public LoginMouseListener getMouseListener() {
        return mouseListener;
    }

    public LoginKeyListener getKeyListener() {
        return keyListener;
    }
}