package com.nocl.studentmanager.view.main.utils;

import com.nocl.studentmanager.Main;
import com.nocl.studentmanager.database.bean.Student;
import com.nocl.studentmanager.view.main.layout.BottomMenu;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

import static com.nocl.studentmanager.view.main.StudentMain.dao;

public class SearchButtonListener extends MouseAdapter {
    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        BottomMenu bottomMenu = Main.studentMain.bottomMenu;
        Student student = new Student();

        if (bottomMenu.getNameInput().getText().equals("")) {
            student.setName(null);
        } else {
            student.setName(bottomMenu.getNameInput().getText());
        }
        if (bottomMenu.getAgeInput().getText().equals("")) {
            student.setAge(null);
        } else {
            student.setAge(Integer.valueOf(bottomMenu.getAgeInput().getText()));
        }
        student.setGender((String) bottomMenu.getGenderComboBox().getSelectedItem());
        student.setAcademy((String) bottomMenu.getAcademyComboBox().getSelectedItem());
        student.setSpecialized((String) bottomMenu.getSpecializedComboBox().getSelectedItem());
        student.setStudentClass((String) bottomMenu.getStudentClassComboBox().getSelectedItem());

        Main.studentMain.studentXLS.setModel(StudentXLSUtils.setStudentTable(dao.getStudentInfo(student), Main.studentMain.studentXLS.getModel()));
    }
}
