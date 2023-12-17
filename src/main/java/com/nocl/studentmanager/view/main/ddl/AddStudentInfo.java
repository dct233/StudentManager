package com.nocl.studentmanager.view.main.ddl;

import com.nocl.studentmanager.Main;
import com.nocl.studentmanager.view.main.ddl.listener.*;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

import static com.nocl.studentmanager.view.main.StudentMain.dao;

public class AddStudentInfo extends JDialog {
    private JLabel title;
    private JTextField nameInput;
    private JTextField ageInput;
    private JTextField addrInput;
    private JComboBox<String> genderComboBox;
    private JComboBox<String> academyComboBox;
    private JComboBox<String> specializedComboBox;
    private JComboBox<String> studentClassComboBox;
    private JButton addButton;

    public AddStudentInfo(JFrame frame) {
        super(frame, "添加");
        GridBagLayout layout = new GridBagLayout();
        layout.columnWidths = new int[4];
        layout.rowHeights = new int[9];
        layout.columnWeights = new double[] {0.25, 0.15, 0.35, 0.25};
        layout.rowWeights = new double[] {0.01, 0.01, 0.01, 0.01, 0.01, 0.01, 0.01, 0.01, 0.125};

        // 根据父类对话框的大小
        int dialogWidth = frame.getWidth() / 4;
        int dialogHeight = (int) (frame.getHeight() / 1.5);

        // 设置对话框的大小
        this.setSize(dialogWidth, dialogHeight);
        this.setLayout(layout);
        initTitle();
        initAllInput();
        initAllComboBox();

        addButton = initAddButton();
        ageInput.addKeyListener(new AgeInputListener());
        academyComboBox.addItemListener(new AcademyComboBoxListener(this.specializedComboBox));
        specializedComboBox.addItemListener(new SpecializedComboBoxListener(this.studentClassComboBox));
        //specializedComboBox.getModel().addListDataListener(new SpecializedComboBoxDataListListener(studentClassComboBox));
        studentClassComboBox.addItemListener(new StudentClassComboBoxListener(this.addButton));
    }
    private void initTitle() {
        title = new JLabel("添加学生信息");
        title.setFont(new Font("微软雅黑", Font.BOLD, 18));
        title.setForeground(Color.DARK_GRAY);
        title.setBackground(Color.CYAN);

        JPanel panel = new JPanel();
        //panel.setBackground(Color.CYAN);
        panel.add(title);

        GridBagConstraints titleGbc = new GridBagConstraints();
        titleGbc.fill = GridBagConstraints.BOTH;
        titleGbc.insets = new Insets(0, 0, 0, 0);
        //titleGbc.anchor = GridBagConstraints.CENTER;
        titleGbc.gridx = 1;
        titleGbc.gridy = 0;
        titleGbc.gridwidth = 2;
        titleGbc.gridheight = 1;

        this.add(panel, titleGbc);
    }
    private void initAllComboBox() {
        initGenderComboBox();
        initAcademyComboBox();
        initSpecializedComboBox();
        initStudentClassComboBox();
    }

    private void initAllInput() {
        nameInput = initInput("姓名", new int[] {0, 1, 2, 1}, new int[] {2, 1, 2, 1});
        ageInput = initInput("年龄", new int[] {0, 2, 2, 1}, new int[] {2, 2, 2, 1});
        addrInput = initInput("地址", new int[] {0, 4, 2, 1}, new int[] {2, 4, 2, 1});
    }

    private void initLabel(String label, int[] labelAddr) {
        JLabel jLabel = new JLabel(label);
        jLabel.setFont(new Font("微软雅黑", Font.BOLD, 13));

        GridBagConstraints labelGbc = new GridBagConstraints();
        labelGbc.fill = GridBagConstraints.BOTH;
        labelGbc.insets = new Insets(5, 0, 5, 5);
        labelGbc.gridx = labelAddr[0];
        labelGbc.gridy = labelAddr[1];
        labelGbc.gridwidth = labelAddr[2];
        labelGbc.gridheight = labelAddr[3];

        JPanel panel = new JPanel();
        panel.add(jLabel);

        this.add(panel, labelGbc);
    }

    private JTextField initInput(String label, int[] labelAddr, int[] inputAddr) {
        JTextField textField = new JTextField();
        textField.setFont(new Font("微软雅黑", Font.BOLD, 13));

        GridBagConstraints textFieldGbc = new GridBagConstraints();
        textFieldGbc.fill = GridBagConstraints.BOTH;
        textFieldGbc.insets = new Insets(5, 0, 5, 5);
        textFieldGbc.gridx = inputAddr[0];
        textFieldGbc.gridy = inputAddr[1];
        textFieldGbc.gridwidth = inputAddr[2];
        textFieldGbc.gridheight = inputAddr[3];

        initLabel(label, labelAddr);
        this.add(textField, textFieldGbc);

        return textField;
    }
    private JComboBox<String> initComboBox(String label, List<String> data, int[] labelAddr, int[] comboBoxAddr) {
        JComboBox<String> comboBox;

        GridBagConstraints comboBoxGbc = new GridBagConstraints();
        comboBoxGbc.fill = GridBagConstraints.BOTH;
        comboBoxGbc.insets = new Insets(5, 0, 5, 5);
        comboBoxGbc.gridx = comboBoxAddr[0];
        comboBoxGbc.gridy = comboBoxAddr[1];
        comboBoxGbc.gridwidth = comboBoxAddr[2];
        comboBoxGbc.gridheight = comboBoxAddr[3];
        initLabel(label, labelAddr);
        try {
            // 初始化时添加空选项
            if (data.get(0) != null) {
                data.add(0, null);
            }
            comboBox = new JComboBox<>(data.toArray(String[]::new));
            comboBox.setFont(new Font("微软雅黑", Font.PLAIN, 15));

            this.add(comboBox, comboBoxGbc);
        } catch (NullPointerException e) {
            //LOGGER.error(e);
            //LOGGER.error(label + "为空, 请先添加一个" + label + "组");
            comboBox = new JComboBox<>(new String[] {});
            this.add(comboBox, comboBoxGbc);
        }
        return comboBox;
    }
    private JButton initAddButton() {
        JButton button = new JButton("添加");
        button.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        button.addMouseListener(new AddButtonListener(this));
        button.setEnabled(false);

        JPanel panel = new JPanel();

        panel.add(button);

        GridBagConstraints buttonGbc = new GridBagConstraints();
        buttonGbc.fill = GridBagConstraints.BOTH;
        //buttonGbc.insets = new Insets(5, 0, 5, 5);
        buttonGbc.gridx = 1;
        buttonGbc.gridy = 9;
        buttonGbc.gridwidth = 2;
        buttonGbc.gridheight = 1;

        this.add(panel, buttonGbc);

        return button;
    }

    private void initGenderComboBox() {
        //genderComboBox = new JComboBox<>(new String[]{"男", "女"});
        List<String> genderList = new ArrayList<>() {{
            add(null);
            add("男");
            add("女");
        }};

        genderComboBox = initComboBox("性别", genderList, new int[] {0, 3, 2, 1}, new int[] {2, 3, 2, 1});
        //genderComboBox.setEnabled(false);
    }

    private void initAcademyComboBox() {
        List<String> academyList = dao.getAcademy();
        academyComboBox = initComboBox("学院", academyList, new int[] {0, 5, 2, 1}, new int[] {2, 5, 2, 1});
        //academyComboBox.setEnabled(false);
    }

    private void initSpecializedComboBox() {
        // 偷懒了, 通过往头列表添加null可以少写一个监听器
        List<String> NULL = new ArrayList<>() {{
            add(null);
        }};
        specializedComboBox = initComboBox("专业", NULL, new int[] {0, 6 ,2 ,1},  new int[] {2, 6, 2, 1});
        specializedComboBox.setEnabled(false);
    }

    private void initStudentClassComboBox() {
        List<String> NULL = new ArrayList<>() {{
            add(null);
        }};
        studentClassComboBox = initComboBox("班级", NULL, new int[] {0, 7, 2, 1}, new int[] {2, 7, 2 , 1});
        //studentClassComboBox.setModel(new DefaultComboBoxModel<>(new String[] {null ,"test"}));
        studentClassComboBox.setEnabled(false);
    }

    public JTextField getNameInput() {
        return nameInput;
    }

    public JTextField getAgeInput() {
        return ageInput;
    }

    public JTextField getAddrInput() {
        return addrInput;
    }

    public JComboBox<String> getGenderComboBox() {
        return genderComboBox;
    }

    public JComboBox<String> getAcademyComboBox() {
        return academyComboBox;
    }

    public JComboBox<String> getSpecializedComboBox() {
        return specializedComboBox;
    }

    public JComboBox<String> getStudentClassComboBox() {
        return studentClassComboBox;
    }
}
