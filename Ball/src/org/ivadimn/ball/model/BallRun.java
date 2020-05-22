package org.ivadimn.ball.model;

import org.ivadimn.ball.ui.BallPanel;

/**
 * Created by vadim on 12.07.16.
 */
public class BallRun implements Runnable {

    private Ball ball;
    private BallPanel panel;

    public BallRun(Ball ball, BallPanel panel) {
        this.ball = ball;
        this.panel = panel;
    }

    @Override
    public void run() {

        for (int i = 0; i < 1000; i++) {
            ball.move(panel.getBounds());
            panel.repaint();
            try {
                Thread.sleep(1);
            }
            catch(InterruptedException ex) {

            }
        }
    }
}
