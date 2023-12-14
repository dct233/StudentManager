package com.nocl.studentmanager.gui.main.listener;

import com.nocl.studentmanager.Main;
import com.nocl.studentmanager.gui.main.ddl.AddStudentInfo;

import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TopMenuListener {
    private final Add add;
    public TopMenuListener(DefaultTableModel model) {
        add = new Add(model);
    }
    static class Add extends MouseAdapter {
        private final DefaultTableModel model;
        public Add(DefaultTableModel model) {
            this.model = model;
        }
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            AddStudentInfo addStudentInfo = new AddStudentInfo(Main.frame);
            addStudentInfo.setLocationRelativeTo(Main.frame);
            addStudentInfo.setModal(true);
            addStudentInfo.setVisible(true);
        }
    }

    public Add getAdd() {
        return add;
    }
}
