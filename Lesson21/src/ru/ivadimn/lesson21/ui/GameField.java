package ru.ivadimn.lesson21.ui;

import ru.ivadimn.lesson21.model.Ball;

import javax.swing.*;
import java.awt.*;

/**
 * Created by vadim on 04.11.2016.
 */
public class GameField extends JFrame  {

    GameCanvas gameCanvas;

    public GameField () {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setScreenLocation();
        setResizable(false);
        gameCanvas = new GameCanvas(this);
        add(gameCanvas, BorderLayout.CENTER);
        initGameObjects();
        setVisible(true);
    }

    private void setScreenLocation() {
        Dimension screenSize = Toolkit.getDefaultToolkit ().getScreenSize ();
        setSize(screenSize.width / 2,  screenSize.height / 2);
        setLocation(screenSize.width / 4, screenSize.height / 4);
    }

    private void initGameObjects() { }

    public void onRepaint(Graphics g, float deltaTime) { }

    private void update(float deltaTime) { }

    private void render(Graphics g) { }

    public void addSprite(float x, float y) {}

}
