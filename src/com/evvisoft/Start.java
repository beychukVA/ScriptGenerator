package com.evvisoft;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

    public Start()
    {
        mFieldEmail.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        mBtnClose.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                System.exit(0);
            }
        });
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
    }

    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.setContentPane(new Start().mPanelStart);
        frame.setLocation(350, 50);
        frame.setUndecorated(true);
        frame.pack();
        frame.setVisible(true);
    }
}
