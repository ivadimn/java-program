package ru.ivadimn.lesson21.common_game_classes;

import ru.ivadimn.lesson21.common_game_classes.CanvasPaintListener;
import ru.ivadimn.lesson21.common_game_classes.GameCanvas;
import ru.ivadimn.lesson21.common_game_classes.GameObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * Created by vadim on 04.11.2016.
 */
public abstract class GameField extends JFrame implements CanvasPaintListener, MouseListener {

    protected ArrayList<GameObject> sprites = new ArrayList<>();

    public GameField () {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setScreenLocation();
        setResizable(false);
        GameCanvas gameCanvas = new GameCanvas(this);
        gameCanvas.addMouseListener(this);
        add(gameCanvas, BorderLayout.CENTER);
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

    public void removeSprite() {
        if (sprites.size() > 1)
            sprites.remove(sprites.size() - 1);
    }

    public abstract void addSprite(float x, float y);


    @Override
    public void mouseClicked(MouseEvent e) {
        //
    }

    @Override
    public void mousePressed(MouseEvent e) {
        float x = e.getX();
        float y = e.getY();
        if (e.getButton() == MouseEvent.BUTTON1)
            addSprite(x, y);
        if (e.getButton() == MouseEvent.BUTTON3)
            removeSprite();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //
    }
}
