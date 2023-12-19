package com.nocl.studentmanager;

import com.alee.api.resource.ClassResource;
import com.alee.laf.WebLookAndFeel;
import com.alee.laf.menu.WebMenuItem;
import com.alee.managers.language.Language;
import com.alee.managers.language.LanguageManager;
import com.alee.managers.language.data.Dictionary;
import com.alee.managers.style.StyleManager;
import com.alee.skin.dark.WebDarkSkin;
import com.alee.skin.flat.FlatSkin;
import com.alee.skin.material.MaterialSkin;
import com.alee.skin.modena.ModenaSkin;
import com.nocl.studentmanager.view.Login;
import com.nocl.studentmanager.view.main.StudentMain;
import com.nocl.studentmanager.view.main.utils.listener.TableModelListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.util.Enumeration;
import java.util.Locale;

public class Main {
    public static final Logger LOGGER = LogManager.getLogger(Main.class);
    public static JFrame frame;
    public static StudentMain studentMain;

    public static void initGobalFont(Font font) {
        FontUIResource fontResource = new FontUIResource(font);
        for(Enumeration<Object> keys = UIManager.getDefaults().keys(); keys.hasMoreElements();) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if(value instanceof FontUIResource) {
                System.out.println(key);
                UIManager.put(key, fontResource);
            }
        }
    }

    public static void main(String[] args) {
        //LOGGER.debug(dao.getStudentClass("物联网信息技术"));
        SwingUtilities.invokeLater(() -> {
            WebLookAndFeel.install();
            LanguageManager.setLanguage(new Language(new Locale("zh")));
            LanguageManager.addDictionary ( new Dictionary(
                    new ClassResource( Main.class, "resources/language.xml" )
            ) );
            initGobalFont(new Font("微软雅黑", Font.PLAIN, 15));

            frame = new JFrame("学生管理系统") {{
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setExtendedState(JFrame.MAXIMIZED_BOTH);
                setSize(1600, 800);
            }};

            //frame.setContentPane(new Login().getRoot());
            studentMain = new StudentMain();
            frame.setContentPane(studentMain.InitMainPanel());
            //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

            frame.setVisible(true);
            frame.requestFocus();
            Main.LOGGER.debug(frame.getGraphics().getFontMetrics(frame.getFont()).stringWidth("A"));


            System.out.println(studentMain.utilsMenu.getHeight());
            System.out.println(studentMain.utilsMenu.getWidth());

            Dimension dimension = new Dimension(studentMain.utilsMenu.getWidth() / 5, studentMain.utilsMenu.getHeight() / 3);
            studentMain.utilsMenu.getAcademyComboBox().setPreferredSize(dimension);
            studentMain.utilsMenu.getGenderComboBox().setPreferredSize(dimension);
            studentMain.utilsMenu.getSpecializedComboBox().setPreferredSize(dimension);
            studentMain.utilsMenu.getStudentClassComboBox().setPreferredSize(dimension);
            studentMain.utilsMenu.getNameInput().setPreferredSize(dimension);
            studentMain.utilsMenu.getAgeInput().setPreferredSize(dimension);
            System.out.println(studentMain.topMenu.getWidth());
        });


        // 登录控件
        //frame.setSize(350, 300);
        //frame.setResizable(false);

        // 在控件失焦时提供回车登录事件监听
        //frame.addKeyListener(new LoginButtonListener().getKeyListener());

        /*dao.insertStudent(
                "ts",
                17,
                "男",
                "12",
                "123",
                "123",
                "123"
        );*/

        LOGGER.info("Nocl");

    }
}
