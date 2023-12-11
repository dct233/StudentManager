package com.nocl.studentmanager.listener;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LoginWindowListener extends WindowAdapter {
    private final JFrame jFrame;

    public LoginWindowListener(JFrame jFrame) {
        this.jFrame = jFrame;
    }

    @Override
    public void windowClosing(WindowEvent e) {
        jFrame.dispose();
    }
}
