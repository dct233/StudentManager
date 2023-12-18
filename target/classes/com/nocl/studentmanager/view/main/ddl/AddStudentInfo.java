package com.nocl.studentmanager.view.main.ddl;

import com.nocl.studentmanager.view.main.ddl.listener.*;
import com.nocl.studentmanager.view.main.utils.InitComponent;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

import static com.nocl.studentmanager.view.main.StudentMain.dao;

public class AddStudentInfo extends JDialog {
    private final JPanel mainPanel;
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
        layout.rowHeights = new int[8];
        layout.columnWeights = new double[] {0.01, 0.15, 0.35, 0.25};
        layout.rowWeights = new double[] {0.01, 0.01, 0.01, 0.01, 0.01, 0.01, 0.01, 0.01};

        mainPanel = new JPanel(layout);
        this.setContentPane(mainPanel);
        // 设置对话框的大小
        this.setSize(280, 480);
        //this.setLayout(layout);
        initTitle();
        initAllInput();
        initAllComboBox();

        addButton = initAddButton();
        ageInput.addKeyListener(new AgeInputListener());
        academyComboBox.addItemListener(new AcademyComboBoxListener(this.specializedComboBox, false));
        specializedComboBox.addItemListener(new SpecializedComboBoxListener(this.studentClassComboBox, false));
        //specializedComboBox.getModel().addListDataListener(new SpecializedComboBoxDataListListener(studentClassComboBox));
        studentClassComboBox.addItemListener(new StudentClassComboBoxListener(addButton));
    }
    private void initTitle() {
        JLabel title = new JLabel("添加学生信息");
        title.setFont(new Font("微软雅黑", Font.BOLD, 18));
        title.setForeground(Color.DARK_GRAY);
        title.setBackground(Color.CYAN);

        JPanel panel = new JPanel();
        //panel.setBackground(Color.CYAN);
        panel.add(title);

        GridBagConstraints titleGbc = new GridBagConstraints();
        titleGbc.fill = GridBagConstraints.BOTH;
        titleGbc.insets = new Insets(0, 40, 0, 0);
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
        nameInput = InitComponent.initInput("姓名", new int[] {0, 1, 2, 1}, new int[] {2, 1, 2, 1}, GridBagConstraints.BOTH, mainPanel);
        ageInput = InitComponent.initInput("年龄", new int[] {0, 2, 2, 1}, new int[] {2, 2, 2, 1}, GridBagConstraints.BOTH, mainPanel);
        addrInput = InitComponent.initInput("地址", new int[] {0, 4, 2, 1}, new int[] {2, 4, 2, 1}, GridBagConstraints.BOTH, mainPanel);
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
        buttonGbc.insets = new Insets(0, 40, 0, 0);
        buttonGbc.gridx = 1;
        buttonGbc.gridy = 8;
        buttonGbc.gridwidth = 2;
        buttonGbc.gridheight = 1;

        mainPanel.add(panel, buttonGbc);

        return button;
    }

    private void initGenderComboBox() {
        List<String> genderList = new ArrayList<>() {{
            add(null);
            add("男");
            add("女");
        }};

        genderComboBox = InitComponent.initComboBox("性别", genderList, new int[] {0, 3, 2, 1}, new int[] {2, 3, 2, 1}, mainPanel);
        //genderComboBox.setEnabled(false);
    }

    private void initAcademyComboBox() {
        academyComboBox = InitComponent.initComboBox("学院", dao.getAcademy(), new int[] {0, 5, 2, 1}, new int[] {2, 5, 2, 1}, mainPanel);
    }

    private void initSpecializedComboBox() {
        // 偷懒了, 通过往头列表添加null可以少写一个监听器
        List<String> NULL = new ArrayList<>() {{
            add(null);
        }};
        specializedComboBox = InitComponent.initComboBox("专业", NULL, new int[] {0, 6 ,2 ,1},  new int[] {2, 6, 2, 1}, mainPanel);
        specializedComboBox.setEnabled(false);
    }

    private void initStudentClassComboBox() {
        List<String> NULL = new ArrayList<>() {{
            add(null);
        }};
        studentClassComboBox = InitComponent.initComboBox("班级", NULL, new int[] {0, 7, 2, 1}, new int[] {2, 7, 2 , 1}, mainPanel);
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

    public JButton getAddButton() {
        return addButton;
    }
}
