package ru.ivadimn.lesson21.ui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by vadim on 02.11.16.
 */
public class GameCanvas  extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.fillOval(100, 100, 200, 100);
    }
}
