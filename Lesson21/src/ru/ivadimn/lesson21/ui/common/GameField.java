package ru.ivadimn.lesson21.ui.common;

import ru.ivadimn.lesson21.common_game_classes.CanvasPaintListener;
import ru.ivadimn.lesson21.common_game_classes.GameCanvas;
import ru.ivadimn.lesson21.common_game_classes.GameObject;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by vadim on 04.11.2016.
 */
public abstract class GameField extends JFrame implements CanvasPaintListener {

    protected ArrayList<GameObject> sprites = new ArrayList<>();

    public GameField () {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setScreenLocation();
        setResizable(false);
        add(new GameCanvas(this), BorderLayout.CENTER);
        setVisible(true);
    }

    private void setScreenLocation() {
        Dimension screenSize = Toolkit.getDefaultToolkit ().getScreenSize ();
        setSize(screenSize.width / 2,  screenSize.height / 2);
        setLocation(screenSize.width / 4, screenSize.height / 4);
    }


    public void onRepaint(GameCanvas gameCanvas, Graphics g, float deltaTime) {
        update(gameCanvas, deltaTime);
        render(gameCanvas, g);
    }

    private void update(GameCanvas gameCanvas, float deltaTime) {
        for (int i = 0; i < sprites.size(); i++) {
            sprites.get(i).update(gameCanvas, deltaTime);
        }
    }

    private void render(GameCanvas gameCanvas, Graphics g) {
        for (int i = 0; i < sprites.size(); i++) {
            sprites.get(i).render(gameCanvas, g);
        }
    }

    public abstract void addSprite(float x, float y);

}
