package com.nocl.studentmanager.view.newLogin;

import com.alee.laf.label.WebLabel;
import com.alee.laf.panel.WebPanel;
import com.alee.managers.style.StyleId;
import com.nocl.studentmanager.listener.LoginButtonAdapter;
import com.nocl.studentmanager.view.main.utils.InitComponent;

import javax.swing.*;
import java.awt.*;

public class Login extends JPanel {
    private WebLabel title;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton searchStudent;
    public Login() {
        GridBagLayout layout = new GridBagLayout();
        layout.columnWidths = new int[4];  // 列
        layout.rowHeights = new int[5];  // 行
        layout.columnWeights = new double[] {0.25, 0.25, 0.25, 0.25}; // 列占比
        layout.rowWeights = new double[] {0.4, 0.2, 0.2, 0.1, 0.1}; // 行占比
        this.setLayout(layout);
        title = new WebLabel(StyleId.of("title"), "学生管理系统");
        title.setFont(new Font("微软雅黑", Font.BOLD, 25));
        //title.setBackground(Color.BLUE);
        WebPanel panel = new WebPanel(new BorderLayout());
        title.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(title);
        panel.setBackground(new Color(63,81,181));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.gridwidth = 4;

        this.add(panel, gbc);
        initField();
        initButtons();
    }
    
    private void initField() {
        usernameField = InitComponent.initInput("用户名", new int[] {0, 1, 1, 1}, new int[] {1, 1, 2, 1}, GridBagConstraints.HORIZONTAL, this);
        passwordField = InitComponent.initPasswordInput("密码", new int[] {0, 2, 1, 1}, new int[] {1, 2, 2, 1}, GridBagConstraints.HORIZONTAL, this);

        usernameField.addKeyListener(new LoginButtonAdapter(usernameField, passwordField));
        passwordField.addKeyListener(new LoginButtonAdapter(usernameField, passwordField));
    }
    private void initButtons() {
        loginButton = new JButton("登录");
        GridBagConstraints loginGbc = new GridBagConstraints();
        //loginGbc.fill = GridBagConstraints.BOTH;
        loginGbc.gridx = 1;
        loginGbc.gridy = 3;
        loginGbc.gridwidth = 1;
        loginGbc.gridheight = 1;

        loginButton.addMouseListener(new LoginButtonAdapter(usernameField, passwordField));
        loginButton.addKeyListener(new LoginButtonAdapter(usernameField, passwordField));

        this.add(loginButton, loginGbc);
    }
}
