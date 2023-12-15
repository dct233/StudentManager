package com.nocl.studentmanager.gui.main.ddl.listener;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
// 令Age输入框只允许输入数字
public class AgeInputListener extends KeyAdapter {
    @Override
    public void keyTyped(KeyEvent e) {
        super.keyTyped(e);
        String key="0123456789"+(char)8;
        if(key.indexOf(e.getKeyChar())<0){
            e.consume();
        }
    }
}
