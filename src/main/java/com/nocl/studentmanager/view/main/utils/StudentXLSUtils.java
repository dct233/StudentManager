package com.nocl.studentmanager.view.main.utils;

import com.nocl.studentmanager.database.bean.Student;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class StudentXLSUtils {
    public static String[] headerTitle = {"学号", "姓名", "年龄", "性别", "地址", "学院", "专业", "班级"};
    public static DefaultTableModel setStudentTable(List<Student> studentList) {
        return new DefaultTableModel(tableDataToObjectArray(studentList), headerTitle) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column != 0;
            }
        };
    }

    public static Object[][] tableDataToObjectArray(List<Student> studentList) {
        Object[][] objects = new Object[studentList.size()][];
        for (int i = 0; i < studentList.size(); i++) {
            objects[i] = studentList.get(i).toObject();
        }

        return objects;
    }
    /*public static DefaultTableModel setStudentTable(List<Student> studentList) {
        return setStudentTable(studentList, null);
    }*/
}
