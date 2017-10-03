package com.evvisoft;

import javax.swing.*;
import java.awt.*;

public class Home
{

    private JPanel mHomePanel;
    private JPanel mJPanelMenu;
    private JPanel mJPanelRoot;
    private JPanel mJPanelLeft;
    private JPanel mJPanelCenter;
    private JButton button1;
    private JPanel mJPanelRight;
    private JTextArea mTextAreaCenter;

    public Home()
    {
        // Параметры переноса слов
        mTextAreaCenter.setLineWrap(true);
        mTextAreaCenter.setWrapStyleWord(true);
    }

    public JPanel getmHomePanel() {
        return mHomePanel;
    }
}
