package ru.ivadimn.lesson21.ui.common;

import ru.ivadimn.lesson21.model.Ball;
import ru.ivadimn.lesson21.model.Sprite;
import ru.ivadimn.lesson21.ui.common.GameCanvas;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by vadim on 04.11.2016.
 */
public abstract class GameField extends JFrame  {

    protected GameCanvas gameCanvas;
    protected ArrayList<GameObject> sprites = new ArrayList<>();

    public GameField () {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setScreenLocation();
        setResizable(false);
        gameCanvas = new GameCanvas(this);
        add(gameCanvas, BorderLayout.CENTER);
        setVisible(true);
    }

    private void setScreenLocation() {
        Dimension screenSize = Toolkit.getDefaultToolkit ().getScreenSize ();
        setSize(screenSize.width / 2,  screenSize.height / 2);
        setLocation(screenSize.width / 4, screenSize.height / 4);
    }


    public void onRepaint(Graphics g, float deltaTime) {
        update(deltaTime);
        render(g);
    }

    private void update(float deltaTime) {
        for (int i = 0; i < sprites.size(); i++) {
            sprites.get(i).update(gameCanvas, deltaTime);
        }
    }

    private void render(Graphics g) {
        for (int i = 0; i < sprites.size(); i++) {
            sprites.get(i).render(gameCanvas, g);
        }
    }

    public abstract void addSprite(float x, float y);

}
