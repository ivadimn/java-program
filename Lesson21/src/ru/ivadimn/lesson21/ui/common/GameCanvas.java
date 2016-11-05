package ru.ivadimn.lesson21.ui.common;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by vadim on 02.11.16.
 */
public class GameCanvas  extends JPanel {

    private long lastFrameTime;
    private GameField gameField;

    GameCanvas(GameField gameField) {
        this.gameField = gameField;
        lastFrameTime = System.nanoTime();

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                float x = e.getX();
                float y = e.getY();
                createSprite(x, y);
            }
        });

    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        long currentTime = System.nanoTime();
        float deltaTime = (currentTime - lastFrameTime) * 0.000000001f;
        lastFrameTime = currentTime;

        gameField.onRepaint(g, deltaTime);
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

    private void createSprite(float x, float y) {
       gameField.addSprite(x, y);
    }

}
