package ru.ivadimn.lesson21.ui;

import ru.ivadimn.lesson21.model.Ball;
import ru.ivadimn.lesson21.model.Sprite;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by vadim on 01.11.16.
 */
public class GameCircle extends JFrame {

    public static void main(String[] args) {
        new GameCircle();
    }

    GameCanvas gameCanvas;
    private int countBall = 2;
    private ArrayList<Sprite> sprites = new ArrayList<>(countBall);


    public GameCircle() {
        setTitle("Кружки");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension sSize = Toolkit.getDefaultToolkit ().getScreenSize ();

        setSize(orderSet.getScreenWidth(), orderSet.getScreenHeight());
        setLocation(orderSet.getLocationX(), orderSet.getLocationY());
        setTitle("Заявка");
        setLocation(100,  100);
        setSize(600, 500);
        setResizable(false);
        gameCanvas = new GameCanvas(this);
        add(gameCanvas, BorderLayout.CENTER);
        initGameObjects();
        setVisible(true);
    }

    private void setScreenLocation() {
        Dimension screenSize = Toolkit.getDefaultToolkit ().getScreenSize ();

        setSize(screenSize.width / 2,  screenSize.height / 2);
        setLocation();
    }

    private void initGameObjects() {
        for (int i = 0; i < countBall; i++) {
            sprites.add(new Ball(gameCanvas));
        }
    }

    public void onRepaint(Graphics g, float deltaTime) {
        update(deltaTime);
        render(g);
    }

    private void update(float deltaTime) {
        for (int i = 0; i < sprites.size(); i++) {
            sprites.get(i).update(deltaTime);
        }
    }

    private void render(Graphics g) {
        for (int i = 0; i < sprites.size(); i++) {
            sprites.get(i).render(g);
        }
    }

    public void addSprite(float x, float y) {
       sprites.add(new Ball(x, y, gameCanvas));
    }
}
