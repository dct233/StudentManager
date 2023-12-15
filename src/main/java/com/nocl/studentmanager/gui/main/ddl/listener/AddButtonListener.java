package com.nocl.studentmanager.gui.main.ddl.listener;

import com.nocl.studentmanager.Main;
import com.nocl.studentmanager.gui.main.StudentMain;
import com.nocl.studentmanager.gui.main.ddl.AddStudentInfo;
import com.nocl.studentmanager.gui.main.utils.StudentXLSUtils;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static com.nocl.studentmanager.gui.main.StudentMain.*;

public class AddButtonListener extends MouseAdapter {
    private AddStudentInfo addStudentInfo;
    public AddButtonListener(AddStudentInfo addStudentInfo) {
        this.addStudentInfo = addStudentInfo;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
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
        studentXLS.setModel(StudentXLSUtils.setStudentTable());
    }
}
