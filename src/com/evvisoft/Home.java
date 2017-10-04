package com.evvisoft;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.plaf.IconUIResource;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

public class Home
{

    private JPanel mHomePanel;
    private JPanel mJPanelMenu;
    private JPanel mJPanelRoot;
    private JPanel mJPanelLeft;
    private JPanel mJPanelCenter;
    private JButton mBtnEdit;
    private JPanel mJPanelRight;
    private JTextArea mTextAreaCenter;
    private JPanel mJPanelQuestionTitle;
    private JPanel mJPanelManager;
    private JPanel mJPanelClient;
    private JPanel mJPanelEditAndLook;
    private JButton mBtnLoook;
    private JButton mBtnNewGroupQuestionManager;
    private JScrollPane mJScrollPaneQuestionsManager;
    private JPanel mJPanelQuestionManagerContent;


    public Home()
    {
        // Параметры переноса слов
        mTextAreaCenter.setLineWrap(true);
        mTextAreaCenter.setWrapStyleWord(true);
        mBtnNewGroupQuestionManager.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                mJPanelQuestionManagerContent.setLayout(new BoxLayout(mJPanelQuestionManagerContent, BoxLayout.Y_AXIS));
                mJPanelQuestionManagerContent.setAlignmentY(Component.TOP_ALIGNMENT);

                //Карточка "Вопросы менеджера"
                //Карточка
                JPanel panelRoot = new JPanel();
                panelRoot.setLayout(new BoxLayout(panelRoot, BoxLayout.Y_AXIS));
                panelRoot.setBorder(new LineBorder(Color.GRAY));
                //Кнопки "Редактировать" и "Удалить" карточку
                JPanel panelEditAndRemove = new JPanel();
                panelEditAndRemove.setLayout(new FlowLayout(FlowLayout.RIGHT));
                panelEditAndRemove.setAlignmentY(Component.TOP_ALIGNMENT);
                //Кнопки
                JButton btnEditCard = new JButton();
                btnEditCard.setIcon(createIcon("images/pencil.png"));
                btnEditCard.setText("Ответ");
                panelEditAndRemove.add(btnEditCard);

                panelRoot.add(panelEditAndRemove);

                mJPanelQuestionManagerContent.add(panelRoot);
                mJScrollPaneQuestionsManager.revalidate();
            }
        });
    }

    protected ImageIcon createIcon(String path)
    {
        URL imgURL = Home.class.getResource(path);
        if (imgURL != null)
        {
            return new ImageIcon(imgURL);
        }
        else
        {
            System.err.println("File not found " + path);
            return null;
        }
    }

    public JPanel getmHomePanel() {
        return mHomePanel;
    }
}
