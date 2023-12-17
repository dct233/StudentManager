package com.nocl.studentmanager.view.main.listener;

import com.alee.utils.swing.menu.JPopupMenuGenerator;
import com.nocl.studentmanager.Main;
import com.nocl.studentmanager.view.main.ddl.AddStudentInfo;

import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TopMenuListener {
    private Add add;
    public TopMenuListener(DefaultTableModel model) {
        add = new Add(model);
    }
    public TopMenuListener() {}
    static class Add extends MouseAdapter {
        private DefaultTableModel model;
        public Add(DefaultTableModel model) {
            this.model = model;
        }
        public Add() {}
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);

            /*
            AddStudentInfo addStudentInfo = new AddStudentInfo(Main.frame);
            addStudentInfo.setLocationRelativeTo(Main.frame);
            addStudentInfo.setModal(true);
            addStudentInfo.setVisible(true);
            */
        }
    }

    public Add getAdd() {
        return add;
    }
}
