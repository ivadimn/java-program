package ru.ivadimn.lesson21.ui;

import ru.ivadimn.lesson21.model.Ball;
import ru.ivadimn.lesson21.model.Sprite;

import javax.swing.*;
import java.awt.*;

/**
 * Created by vadim on 01.11.16.
 */
public class GameCircle extends JFrame {

    public static void main(String[] args) {
        new GameCircle();
    }

    GameCanvas gameCanvas;
    private final Sprite[] sprites = new Sprite[7];


    public GameCircle() {
        setTitle("Кружки");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(100,  100);
        setSize(600, 500);
        setResizable(false);
        gameCanvas = new GameCanvas(this);
        add(gameCanvas, BorderLayout.CENTER);
        initGameObjects();
        setVisible(true);
    }

    private void initGameObjects() {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i] = new Ball(gameCanvas);
        }
    }

    public void onRepaint(Graphics g, float deltaTime) {
        update(deltaTime);
        render(g);
    }

    private void update(float deltaTime) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].update(deltaTime);
        }
    }

    private void render(Graphics g) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].render(g);
        }
    }
}
