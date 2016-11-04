package ru.ivadimn.lesson21.ui;

import ru.ivadimn.lesson21.model.Ball;
import ru.ivadimn.lesson21.model.Sprite;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by vadim on 04.11.2016.
 */
public class GameRect extends JFrame {

    public static void main(String[] args) {
        new GameCircle();
    }

    GameCanvas gameCanvas;
    private int countBall = 2;
    private ArrayList<Sprite> sprites = new ArrayList<>(countBall);

    public GameRect() {
        setTitle("Прямоугольники");
    }

    private void setScreenLocation() {
        Dimension screenSize = Toolkit.getDefaultToolkit ().getScreenSize ();
        setSize(screenSize.width / 2,  screenSize.height / 2);
        setLocation(screenSize.width / 4, screenSize.height / 4);
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
