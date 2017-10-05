package com.evvisoft.utill;

import javax.swing.*;
import java.awt.*;

public class VerticalLayout implements LayoutManager
{
        // отступ между компонентами
        public int GAP = 5;
        // сигнал расположить компоненты в контейнере
        public void layoutContainer(Container c)
        {
            Component comps[] = c.getComponents();
            int currentY = GAP;
            for (Component comp : comps)
            {
                // предпочтительный размер компонента
//                Dimension pref = comp.getPreferredSize();
                Dimension pref = c.getParent().getSize();
                // указываем положение компонента на экране
                comp.setBounds(GAP, currentY,
                        pref.width - GAP, pref.width/2 - GAP);
                // промежуток между компонентами
                currentY += GAP;
                currentY += pref.width/2;
            }
        }
        // эти два метода нам не понадобятся
        public void addLayoutComponent(
                String name, Component comp) {
        }
        public void removeLayoutComponent(
                Component comp) {
        }
        // минимальный размер для контейнера
        public Dimension minimumLayoutSize(Container c) {
            return calculateBestSize(c);
        }
        // предпочтительный размер для контейнера
        public Dimension preferredLayoutSize(Container c) {
            return calculateBestSize(c);
        }


        private Dimension size = new Dimension();
        // вычисляет оптимальный размер контейнера
        private Dimension calculateBestSize(Container c)
        {
            // сначала вычислим длину контейнера
            Component[] comps = c.getComponents();
            int maxWidth = 0;
            for (Component comp : comps)
            {
                int width = comp.getWidth();
                // поиск компонента с максимальной длиной
                if (width > maxWidth) maxWidth = width;
            }
            // длина контейнера с учетом левого отступа
            size.width = maxWidth + GAP;
            // вычисляем высоту контейнера
            int height = 0;
            for (Component comp : comps)
            {
                height += GAP;
                height += comp.getHeight();
            }
            size.height = height;
            return size;
        }
    }
