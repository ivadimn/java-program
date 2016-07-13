package org.ivadimn.ball.ui;

import org.ivadimn.ball.model.Ball;
import org.ivadimn.ball.model.BallRun;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by vadim on 10.07.16.
 */
public class BallFrame extends JFrame {

    public static final int DEFAULT_WIDTH = 400;
    public static final int DEFAULT_HEIGHT = 400;
    BallPanel ballPanel;

    public BallFrame() {

        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        ballPanel = new BallPanel();
        add(ballPanel, BorderLayout.CENTER);
        addButtonPanel();
        setVisible(true);
    }

    private void addButtonPanel() {
        JPanel btnPanel = new JPanel();
        JButton btnAdd = new JButton("Новый мяч");
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addBall();
            }
        });
        btnPanel.add(btnAdd);
        add(btnPanel, BorderLayout.SOUTH);
    }



    private void addBall() {
        Ball b = new Ball();
        ballPanel.addBall(b);
        BallRun run = new BallRun(b, ballPanel);
        Thread thread = new Thread(run);
        thread.start();
    }


}
