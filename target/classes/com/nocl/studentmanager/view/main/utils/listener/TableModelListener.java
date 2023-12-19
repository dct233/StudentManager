package com.nocl.studentmanager.view.main.utils.listener;

import com.nocl.studentmanager.Main;
import com.nocl.studentmanager.view.main.utils.StudentXLSUtils;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;

import java.util.Arrays;
import java.util.Vector;

import static com.nocl.studentmanager.view.main.StudentMain.dao;
import static com.nocl.studentmanager.view.main.StudentMain.sqlSession;
import static javax.swing.JOptionPane.QUESTION_MESSAGE;

public class TableModelListener implements javax.swing.event.TableModelListener {
    private DefaultTableModel model;
    private Vector<Vector> oldModel;
    public TableModelListener(DefaultTableModel model, DefaultTableModel oldModel) {
        this.model = model;
        this.oldModel = new Vector<>(model.getDataVector());
    }
    @Override
    public void tableChanged(TableModelEvent e) {
        // 临时关闭当前监听, 防止监听循环导致栈溢出
        model.removeTableModelListener(this);
        System.out.println(oldModel);
        if (e.getType() == TableModelEvent.UPDATE && oldModel != null) {
            int row = e.getFirstRow();
            int column = e.getColumn();
            Integer uid = Integer.valueOf((String) model.getValueAt(row, 0));
            String value = (String) model.getValueAt(row, column);
            System.out.println(value);
            switch (column) {
                case 1 -> dao.updateStudentName(uid, value);
                case 2 -> // 年龄
                        dao.updateStudentAge(uid, Integer.valueOf(value));
                case 3 -> {
                    // 性别
                    if (value.equals("男") || value.equals("女") || value.equals("未知")) {
                        dao.updateStudentGender(uid, value);
                    } else {
                        resetModel("不知道性别可以填未知");
                    }
                }
                case 4 -> dao.updateStudentAddr(uid, value);
                case 5 -> {
                    Integer academy = dao.getAcademyUid(value);
                    System.out.println(academy);
                    if (academy != null) {
                        dao.updateStudentAcademy(uid, academy);
                    } else {
                        resetModel(value + " 不存在, 请先添加对应群组!");
                    }
                }
                case 6 -> {
                    Integer specialized = dao.getSpecializedUid(value);
                    System.out.println(specialized);
                    if (specialized != null) {
                        //dao.updateStudentAcademy(uid, value);
                        dao.updateStudentSpecialized(uid, specialized);
                    } else {
                        resetModel(value + " 不存在, 请先添加对应群组!");
                    }
                }
                case 7 -> {
                    Integer studentClass = dao.getStudentClassUid(value);
                    if (studentClass != null) {
                        //dao.updateStudentAcademy(uid, value);
                        dao.updateStudentClass(uid, studentClass);
                    } else {
                        resetModel(value + " 不存在, 请先添加对应群组!");
                    }
                }
            }
        }
        sqlSession.commit();
        model.addTableModelListener(this);
    }

    private void resetModel(String value) {
        Main.studentMain.studentXLS.getStudentTable().getCellEditor().stopCellEditing();
        model.setDataVector(oldModel, new Vector<>() {{
            this.addAll(Arrays.asList(StudentXLSUtils.headerTitle));
        }});

        JOptionPane.showOptionDialog(Main.frame, value, "null", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, new Object[]{"确定"}, null);
    }

    public void setModel(DefaultTableModel model) {
        this.model = model;
    }
    public void setOldModel(Vector<Vector> oldModel) {
        this.oldModel = new Vector<>(oldModel);
    }
}
