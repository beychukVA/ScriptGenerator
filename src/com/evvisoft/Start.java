package com.evvisoft;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static java.awt.Frame.MAXIMIZED_BOTH;

/**
 * Окно Решистрации/Входа в программу
 */
public class Start
{
    private JPanel mPanelStart;
    private JPanel mLeftPanel;
    private JPanel mRightPanel;
    private JLabel mBtnClose;
    private JLabel mLabelChart;
    private JTextField mFieldEmail;
    private JPasswordField mFieldPassword;
    private JButton mBtnRegistration;
    private JButton mBtnLogin;
    private JFrame frame;

    public Start()
    {
        mFieldEmail.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        mFieldPassword.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        mFieldEmail.addFocusListener(new FocusAdapter()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                if(mFieldEmail.getText().equals("Enter email"))
                {
                    mFieldEmail.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e)
            {
                if(mFieldEmail.getText().isEmpty())
                {
                    mFieldEmail.setText("Enter email");
                }
            }
        });
        mFieldPassword.addFocusListener(new FocusAdapter()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                if(String.valueOf(mFieldPassword.getPassword()).equals("Enter password"))
                {
                    mFieldPassword.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e)
            {
                if(String.valueOf(mFieldPassword.getPassword()).isEmpty())
                {
                    mFieldPassword.setText("Enter password");
                }
            }
        });
        mBtnLogin.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                //Скрываю окно "Старт"
                frame.setVisible(false);

                //Отобразаю "Главное окно программы"
                JFrame frame = new JFrame();
                frame.setContentPane(new Home().getmHomePanel());
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.setLocation(300, 100);
                frame.setResizable(false);
                frame.pack();
                frame.setVisible(true);
                frame.setExtendedState(MAXIMIZED_BOTH);
            }
        });
    }

    public static void main(String[] args)
    {
        Start start = new Start();
        start.frame = new JFrame();
        start.frame.setContentPane(start.mPanelStart);
        start.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //Меняю иконку приложения
        start.frame.setIconImage(Toolkit.getDefaultToolkit().getImage("com/evvisoft/images/logo.png"));
        start.frame.setLocation(300, 100);
//        frame.setUndecorated(true);
        start.frame.pack();
        start.frame.setVisible(true);
    }
}
