package ru.ivadimn.lesson21.common_game_classes;

import javax.swing.*;
import java.awt.*;

/**
 * Created by vadim on 02.11.16.
 */
public class GameCanvas  extends JPanel {

    private long lastFrameTime;
    private CanvasPaintListener listener;

    public GameCanvas(CanvasPaintListener listener) {
        this.listener = listener;
        lastFrameTime = System.nanoTime();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        long currentTime = System.nanoTime();
        float deltaTime = (currentTime - lastFrameTime) * 0.000000001f;
        lastFrameTime = currentTime;

        listener.onRepaint(this, g, deltaTime);
        //засыпаем
        try {
            Thread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        repaint();
    }

    public int getLeft() {return 0;}
    public int getRight() {return getWidth() - 1;}
    public int getTop() {return 0;}
    public int getBottom() {return getHeight() - 1;}

}
