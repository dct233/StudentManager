package com.nocl.studentmanager.view.main.add.listener;

import com.nocl.studentmanager.Main;
import com.nocl.studentmanager.view.main.add.AddStudentInfo;

import javax.swing.tree.TreePath;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
            // 通过重置树选择节点来刷新表格
            Main.studentMain.leftMenu.getTree().clearSelection();
            Main.studentMain.leftMenu.getTree().setSelectionPath(selectionPath);
        }
    }
}
