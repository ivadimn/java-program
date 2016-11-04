package ru.ivadimn.lesson21.ui;

import ru.ivadimn.lesson21.model.Ball;
import ru.ivadimn.lesson21.model.Sprite;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by vadim on 02.11.16.
 */
public class GameCanvas  extends JPanel {

    private long lastFrameTime;
    private GameField gameFiled;

    GameCanvas(GameField gameField) {
        this.gameFiled = gameFiled;
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

        gameFiled.onRepaint(g, deltaTime);
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
       gameFiled.addSprite(x, y);
    }

}
