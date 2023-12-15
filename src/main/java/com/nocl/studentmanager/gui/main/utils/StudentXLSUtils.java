package com.nocl.studentmanager.gui.main.utils;

import com.nocl.studentmanager.database.bean.Student;

import javax.swing.table.DefaultTableModel;
import java.util.List;

import static com.nocl.studentmanager.gui.main.StudentMain.dao;

public class StudentXLSUtils {
    public static DefaultTableModel setStudentTable() {
        List<Student> studentList = dao.getStudentInfo();
        String[] headerTitle = {"学号", "姓名", "年龄", "性别", "地址", "学院", "专业", "班级"};

        Object[][] objects = new Object[studentList.size()][];
        for (int i = 0; i < studentList.size(); i++) {
            objects[i] = studentList.get(i).toObject();
        }

        return new DefaultTableModel(objects, headerTitle);
    }
}
