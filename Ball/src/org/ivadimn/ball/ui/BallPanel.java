package org.ivadimn.ball.ui;

import org.ivadimn.ball.model.Ball;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vadim on 12.07.16.
 */
public class BallPanel extends JPanel {

    public static final int DEFAULT_WIDTH = 450;
    public static final int DEFAULT_HEIGHT = 350;
    List<Ball> balls = new ArrayList<>();


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        for (Ball b : balls)
            g2.fill(b.getShape());

    }

    public void addBall(Ball b) {
        balls.add(b);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
