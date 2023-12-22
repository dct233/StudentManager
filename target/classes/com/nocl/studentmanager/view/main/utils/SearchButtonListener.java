package com.nocl.studentmanager.view.main.utils;

import com.nocl.studentmanager.Main;
import com.nocl.studentmanager.database.bean.Student;
import com.nocl.studentmanager.view.main.layout.BottomMenu;
import com.nocl.studentmanager.view.main.layout.StudentXLS;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
        Main.studentMain.studentXLS.getModel().removeTableModelListener(StudentXLS.studentTableModelListener);
        StudentXLS.minPage = 1;
        StudentXLS.maxPage = 0;
        StudentXLS.student = null;
        Main.studentMain.studentXLS.getLastButton().setEnabled(false);
        Main.studentMain.studentXLS.getNextButton().setEnabled(true);
        Main.studentMain.studentXLS.getPage().setText(StudentXLS.minPage + " / " + (StudentXLS.maxPage + 1));
        // 获取头50条数据并设置到table
        Main.studentMain.studentXLS.getModel().setDataVector(StudentXLSUtils.tableDataToObjectArray(dao.getStudentIndex(student, 0, 50)), StudentXLSUtils.headerTitle);
        Main.studentMain.studentXLS.getModel().addTableModelListener(StudentXLS.studentTableModelListener);
    }
}
