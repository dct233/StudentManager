package com.nocl.studentmanager.view.main.layout;

import com.nocl.studentmanager.view.main.listener.SearchAcademyComboBoxListener;
import com.nocl.studentmanager.view.main.listener.SearchSpecializedComboBoxListener;
import com.nocl.studentmanager.view.main.listener.SearchStudentClassComboBoxListener;
import com.nocl.studentmanager.view.main.utils.InitComponent;
import com.nocl.studentmanager.view.main.utils.SearchButtonListener;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static com.nocl.studentmanager.view.main.StudentMain.dao;

public class BottomMenu extends JPanel {
    private final GridBagConstraints gbc;
    private JTextField nameInput;
    private JTextField ageInput;
    private JComboBox<String> genderComboBox;
    private JComboBox<String> academyComboBox;
    private JComboBox<String> specializedComboBox;
    private JComboBox<String> studentClassComboBox;
    private JButton searchButton;

    public BottomMenu() {
        // this.setBackground(Color.GREEN);
        GridBagLayout layout = new GridBagLayout();
        layout.columnWidths = new int[5];  // 列
        layout.rowHeights = new int[3];  // 行
        layout.columnWeights = new double[] {0.1, 0.2, 0.1, 0.2, 0.3}; // 列占比
        layout.rowWeights = new double[] {0.1, 0.1, 0.1}; // 行占比
        this.setLayout(layout);

        gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;

        initAllInput();
        initAllComboBox();
        initSearchButton();
    }

    private void initAllInput() {
        nameInput = InitComponent.initInput("姓名", new int[] {0, 0, 1, 1}, new int[] {1, 0, 1, 1}, GridBagConstraints.HORIZONTAL,this);
        ageInput = InitComponent.initInput("年龄", new int[] {2, 0, 1, 1}, new int[] {3, 0, 1, 1}, GridBagConstraints.HORIZONTAL,this);
    }
    private void initAllComboBox() {
        genderComboBox = InitComponent.initComboBox(
                "性别",
                new ArrayList<>() {{
                    add(null);
                    add("男");
                    add("女");
                }},
                new int[] {0, 1, 1, 1},
                new int[] {1, 1, 1, 1},
                GridBagConstraints.HORIZONTAL,
                this
                );
        academyComboBox = InitComponent.initComboBox("学院", dao.getAcademy(), new int[] {2, 1, 1, 1}, new int[] {3, 1, 1, 1}, GridBagConstraints.HORIZONTAL, this);
        specializedComboBox = InitComponent.initComboBox("专业", dao.getAllSpecialized(), new int[] {0, 2, 1, 1}, new int[] {1, 2, 1, 1}, GridBagConstraints.HORIZONTAL, this);
        studentClassComboBox = InitComponent.initComboBox("班级", dao.getAllStudentClass(), new int[] {2, 2, 1, 1}, new int[] {3, 2, 1, 1}, GridBagConstraints.HORIZONTAL, this);

        academyComboBox.addItemListener(new SearchAcademyComboBoxListener(specializedComboBox, studentClassComboBox));
        specializedComboBox.addItemListener(new SearchSpecializedComboBoxListener(academyComboBox, studentClassComboBox));
        studentClassComboBox.addItemListener(new SearchStudentClassComboBoxListener(academyComboBox, specializedComboBox));
    }
    private void initSearchButton() {
        searchButton = new JButton("查询");

        searchButton.addMouseListener(new SearchButtonListener());

        GridBagConstraints searchButtonGbc = new GridBagConstraints();
        searchButtonGbc.anchor = GridBagConstraints.CENTER;
        searchButtonGbc.gridx = 4;
        searchButtonGbc.gridy = 1;
        searchButtonGbc.gridwidth = 1;
        searchButtonGbc.gridheight = 1;

        this.add(searchButton, searchButtonGbc);
    }

    public JTextField getNameInput() {
        return nameInput;
    }

    public void setNameInput(JTextField nameInput) {
        this.nameInput = nameInput;
    }

    public JTextField getAgeInput() {
        return ageInput;
    }

    public void setAgeInput(JTextField ageInput) {
        this.ageInput = ageInput;
    }

    public JComboBox<String> getGenderComboBox() {
        return genderComboBox;
    }

    public void setGenderComboBox(JComboBox<String> genderComboBox) {
        this.genderComboBox = genderComboBox;
    }

    public JComboBox<String> getAcademyComboBox() {
        return academyComboBox;
    }

    public void setAcademyComboBox(JComboBox<String> academyComboBox) {
        this.academyComboBox = academyComboBox;
    }

    public JComboBox<String> getSpecializedComboBox() {
        return specializedComboBox;
    }

    public void setSpecializedComboBox(JComboBox<String> specializedComboBox) {
        this.specializedComboBox = specializedComboBox;
    }

    public JComboBox<String> getStudentClassComboBox() {
        return studentClassComboBox;
    }

    public void setStudentClassComboBox(JComboBox<String> studentClassComboBox) {
        this.studentClassComboBox = studentClassComboBox;
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public void setSearchButton(JButton searchButton) {
        this.searchButton = searchButton;
    }

    public GridBagConstraints getGbc() {
        return gbc;
    }
}
