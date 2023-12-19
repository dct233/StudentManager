package com.nocl.studentmanager.view.main.ddl.listener;

import com.nocl.studentmanager.Main;
import com.nocl.studentmanager.database.bean.Student;
import com.nocl.studentmanager.view.main.ddl.AddStudentInfo;
import com.nocl.studentmanager.view.main.utils.StudentXLSUtils;

import javax.swing.*;
import javax.swing.tree.TreePath;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import static com.nocl.studentmanager.view.main.StudentMain.*;

public class AddButtonListener extends MouseAdapter {
    private final AddStudentInfo addStudentInfo;
    public AddButtonListener(AddStudentInfo addStudentInfo) {
        this.addStudentInfo = addStudentInfo;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        if (addStudentInfo.getAddButton().isEnabled()) {
            dao.insertStudent(
                    addStudentInfo.getNameInput().getText(),
                    Integer.valueOf(addStudentInfo.getAgeInput().getText()),
                    (String) addStudentInfo.getGenderComboBox().getSelectedItem(),
                    addStudentInfo.getAddrInput().getText(),
                    (String) addStudentInfo.getAcademyComboBox().getSelectedItem(),
                    (String) addStudentInfo.getSpecializedComboBox().getSelectedItem(),
                    (String) addStudentInfo.getStudentClassComboBox().getSelectedItem()
            );
            sqlSession.commit();
            addStudentInfo.dispose();

            TreePath selectionPath = Main.studentMain.leftMenu.getTree().getSelectionPath();

            Main.studentMain.leftMenu.getTree().clearSelection();
            Main.studentMain.leftMenu.getTree().setSelectionPath(selectionPath);
        }
    }
}
